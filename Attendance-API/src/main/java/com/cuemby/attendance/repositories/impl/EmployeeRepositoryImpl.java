package com.cuemby.attendance.repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cuemby.attendance.domain.Employee;
import com.cuemby.attendance.repositories.IEmployeeRepository;


@Component
public class EmployeeRepositoryImpl implements IEmployeeRepository{
	
	private List<Employee> employees;
	
	public EmployeeRepositoryImpl() {
		this.employees = new  ArrayList<>();
	}

	@Override
	public List<Employee> findAll() {
		return this.employees;
	}

	@Override
	public List<Employee> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> saveAll(Iterable<Employee> entities) {
		entities.forEach(employees::add);
		
		return this.employees;
	}

	@Override
	public Optional<Employee> save(Employee entity) {
		this.employees.add(entity);
		
		return getOne(entity.getId());
	}

	@Override
	public void deleteInBatch(Iterable<Employee> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Employee> getOne(String id) {
		return this.employees.stream().
							 filter(e-> e.getId() == id)
							 .findFirst();
//							 .map(Optional::of);
							 
	}


	
}
