package com.cuemby.attendance.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cuemby.attendance.repositories.IEmployeeRepository;
import com.cuemby.attendance.services.IEmployeeService;
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
								 .stream()
								  .map(employeeMapper::employeeToEmployeeDTO)
								  .collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO saveOrUpdate(EmployeeDTO domainObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}
