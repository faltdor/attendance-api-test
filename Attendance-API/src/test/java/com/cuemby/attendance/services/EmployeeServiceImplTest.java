package com.cuemby.attendance.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cuemby.attendance.domain.Employee;
import com.cuemby.attendance.repositories.IEmployeeRepository;
import com.cuemby.attendance.services.impl.EmployeeServiceImpl;
import com.cuemby.attendance.v1.model.EmployeeDTO;
import com.cuemby.attendance.v1.model.mappers.IEmployeeMapper;


public class EmployeeServiceImplTest {

	@Mock
	IEmployeeRepository employeeRepository;

	EmployeeServiceImpl employeeServiceImpl;
	
	DateTimeFormatter formatter;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.employeeServiceImpl = new EmployeeServiceImpl(employeeRepository, IEmployeeMapper.INSTANCE);
	}

	@Test
	public void testListAll() {
		// Given
		List<Employee> employees = new ArrayList<>(2);
		
		Employee employee1 = new Employee();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");
		employees.add(employee1);
		
		Employee employee2 = new Employee();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");
		employees.add(employee2);
		
		Employee employee3 = new Employee();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");
		employees.add(employee3);
		
		when(employeeRepository.findAll()).thenReturn(employees);
		
		//When
		List<EmployeeDTO> employeeList = employeeServiceImpl.listAll();
		
		assertThat(employeeList).isNotNull();
		assertThat(employeeList).isNotEmpty();
		assertThat(employeeList.size()).isEqualTo(3);
		
	}

	

}
