package com.cuemby.attendance.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cuemby.attendance.domain.Employee;
import com.cuemby.attendance.repositories.IEmployeeRepository;
import com.cuemby.attendance.services.IEmployeeService;
import com.cuemby.attendance.services.exception.ResourceAlreadyExistsException;
import com.cuemby.attendance.services.exception.ResourceNotFoundException;
import com.cuemby.attendance.v1.model.EmployeeDTO;
import com.cuemby.attendance.v1.model.mappers.IEmployeeMapper;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	private final IEmployeeRepository employeeRepository;
	private final IEmployeeMapper employeeMapper;
	
	public EmployeeServiceImpl(IEmployeeRepository employeeRepository,IEmployeeMapper employeeMapper) {
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
	}

	@Override
	public List<EmployeeDTO> listAll() {
		return employeeRepository.findAll()
							     .values()
								 .stream()
								  .map(employeeMapper::employeeToEmployeeDTO)
								  .collect(Collectors.toList());
	}


	@Override
	public EmployeeDTO create(EmployeeDTO employeeDto) {
		
		if(employeeRepository.employeeExist(employeeDto.getIdentification())) {
			
			throw new ResourceAlreadyExistsException("The user "+employeeDto.getIdentification()+" is already registered.");
		}
		
		Employee employee = employeeRepository.save(employeeMapper.employeeDTOToEmployee(employeeDto));
		
		return employeeMapper.employeeToEmployeeDTO(employee);	
	
	}

	
	@Override
	public void updateEstatusEmployeeInactive(String id) {
		employeeRepository.getOne(id).map(employee -> {
			employee.setStatus("Inactive");
			return employeeMapper.employeeToEmployeeDTO(employeeRepository.update(employee));
		}).orElseThrow(ResourceNotFoundException::new);

				
	}

}
