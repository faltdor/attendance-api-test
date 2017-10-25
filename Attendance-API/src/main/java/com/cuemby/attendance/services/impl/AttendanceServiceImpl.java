package com.cuemby.attendance.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cuemby.attendance.domain.Attendance;
import com.cuemby.attendance.domain.Employee;
import com.cuemby.attendance.repositories.IAttendanceRespository;
import com.cuemby.attendance.repositories.IEmployeeRepository;
import com.cuemby.attendance.services.IAttendanceService;
import com.cuemby.attendance.services.exception.ResourceNotFoundException;
import com.cuemby.attendance.v1.model.AttendanceDTO;
import com.cuemby.attendance.v1.model.mappers.IAttendanceMapper;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

	private final IAttendanceRespository attendanceRepository;
	private final IEmployeeRepository employeeRepository;
	private final IAttendanceMapper attendanceMapper;

	public AttendanceServiceImpl(IAttendanceRespository attendanceRepository, IAttendanceMapper attendanceMapper,
			IEmployeeRepository employeeRepository) {
		this.attendanceRepository = attendanceRepository;
		this.attendanceMapper = attendanceMapper;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public AttendanceDTO create(AttendanceDTO attendanceDto) {

		Optional<Employee> optionalEmployee = employeeRepository.getOne(attendanceDto.getEmployeeId());

		if (!optionalEmployee.isPresent()) {

			throw new ResourceNotFoundException("The user " + attendanceDto.getEmployeeId() + "  is not registered.");
		}

		Attendance attendance = attendanceRepository.save(attendanceMapper.attendanceDTOToAttendance(attendanceDto));

		return attendanceMapper.attendanceToAttendanceDTO(attendance);

	}

	@Override
	public List<AttendanceDTO> listAll() {
		return attendanceRepository.findAll().values().stream().map(attendanceMapper::attendanceToAttendanceDTO)
				.collect(Collectors.toList());
	}

}
