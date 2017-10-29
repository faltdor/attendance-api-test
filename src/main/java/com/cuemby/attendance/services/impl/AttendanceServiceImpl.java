package com.cuemby.attendance.services.impl;


import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cuemby.attendance.domain.Attendance;
import com.cuemby.attendance.domain.Employee;
import com.cuemby.attendance.enums.StatusEmployee;
import com.cuemby.attendance.model.v1.AttendanceDTO;
import com.cuemby.attendance.model.v1.AttendanceEmployeeDTO;
import com.cuemby.attendance.model.v1.AttendanceFilterDTO;
import com.cuemby.attendance.model.v1.mappers.IAttendanceMapper;
import com.cuemby.attendance.repositories.IAttendanceRespository;
import com.cuemby.attendance.repositories.IEmployeeRepository;
import com.cuemby.attendance.services.IAttendanceService;
import com.cuemby.attendance.services.exception.BadArgumentFormatException;
import com.cuemby.attendance.services.exception.ResourceNotFoundException;
import com.cuemby.attendance.utils.ConverterDateFormatter;

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

		Optional<Employee> optionalEmployee = employeeRepository.findByIdentification(StatusEmployee.ACTIVE.toString(),
														attendanceDto.getEmployeeId());

		if (!optionalEmployee.isPresent()) {

			throw new ResourceNotFoundException("The user " + attendanceDto.getEmployeeId() + "  is not registered.");
		}
		attendanceDto.setEmployeeId(optionalEmployee.get().getId());
		Attendance attendance = attendanceRepository.save(attendanceMapper.attendanceDTOToAttendance(attendanceDto));

		return attendanceMapper.attendanceToAttendanceDTO(attendance);

	}

	@Override
	public List<AttendanceDTO> listAll() {
		return attendanceRepository.findAll().values().stream().map(attendanceMapper::attendanceToAttendanceDTO)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<AttendanceEmployeeDTO> listEmployeeAttendance(String init,String end) {
		Date dateInit ;
		Date dateEnd;
		try {
			dateEnd = ConverterDateFormatter.getDateFromString(end, ConverterDateFormatter.YYYYMMDD);
			dateInit = ConverterDateFormatter.getDateFromString(init, ConverterDateFormatter.YYYYMMDD);
		} catch (DateTimeParseException | ParseException e) {
			throw new BadArgumentFormatException("Error creating the parameters to date type. The expected format was yyyy/MM/dd and "+init+" : "+end+" was received");
		} 
		
		List<Attendance> attList = attendanceRepository.findAllByDateInitDateEnd(dateInit,dateEnd);
		
		if (attList.isEmpty()) {

			throw new ResourceNotFoundException("No records were found for the dates given.");
		}
		
		List<AttendanceEmployeeDTO> listAttendance = new ArrayList<>(attList.size());
		
		
		attList.forEach(atten -> {
			
			Optional<Employee> optional = employeeRepository.findAllByStatusId(StatusEmployee.ACTIVE.toString(), atten.getEmployeeId());
			
			if(optional.isPresent()) {
				Employee employee = optional.get();
				listAttendance.add(
						new AttendanceEmployeeDTO(atten.getCurrentDateAssistance(),
								employee.getId(),
								employee.getIdentification(),
								employee.getFirstName(),
								employee.getLastName(),
								employee.getAge(),
								employee.getPosition(),
								employee.getSalary(),
								employee.getBirthdate(),
								employee.getDateAdmission(),
								employee.getStatus()));
				
			}
					
			
		});
		
		
		return listAttendance;
	}


}
