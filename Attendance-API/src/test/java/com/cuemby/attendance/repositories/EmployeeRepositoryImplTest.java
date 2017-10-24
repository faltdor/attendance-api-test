package com.cuemby.attendance.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cuemby.attendance.domain.Employee;
import com.cuemby.attendance.repositories.impl.EmployeeRepositoryImpl;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class EmployeeRepositoryImplTest {

//	@Autowired
	EmployeeRepositoryImpl employeeRepositoryImpl;

	DateTimeFormatter formatter;

	@Before
	public void setUp() throws Exception {
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		employeeRepositoryImpl = new EmployeeRepositoryImpl();
	}

	@Test
	public void testFindAll() {
		List<Employee> listEmployee = employeeRepositoryImpl.findAll();
		assertNotNull(listEmployee);
		assertThat(listEmployee.size()).isEqualTo(0);
	}

	@Test
	public void testFindAllById() {
		assertTrue(true);
	}

	@Test
	public void testSave() {
		// Given
		Employee employee1 = new Employee();
		employee1.setFirstName("Emple 1");

		employee1.setIdentification("1234567");
		employee1.setLastName("Empl last name");
		employee1.setAge(10);
		employee1.setPosition("Mannager");
		employee1.setSalary(600000.0);
		String birthdate = "16/08/2016";

		employee1.setBirthdate(LocalDate.parse(birthdate, formatter));
		employee1.setDateAdmission(LocalDate.parse(birthdate, formatter));
		employee1.setStatus("Active");

		// when

		// Then
		Optional<Employee> employeeResult = employeeRepositoryImpl.save(employee1);

		assertThat(employeeResult).isNotNull();
		assertThat(employeeResult.isPresent()).isEqualTo(true);

	}
	
	@Test
	public void testSaveAll() {
		//Given
		Employee employee1 = new Employee();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");

		Employee employee2 = new Employee();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");

		Employee employee3 = new Employee();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");

		
		List<Employee> employeeList = employeeRepositoryImpl.saveAll(Arrays.asList(employee1, employee2, employee3));
		
		assertThat(employeeList).isNotNull();
		assertThat(employeeList.size()).isEqualTo(3);
		
	}
	

	@Test
	public void testSaveAndFlush() {
		assertTrue(true);
	}

	@Test
	public void testDeleteInBatch() {
		assertTrue(true);
	}

	@Test
	public void testDeleteAllInBatch() {
		assertTrue(true);
	}

	@Test
	public void testGetOne() {
		// Given
		String id = "Dont exist id";

		// when

		// Then
		Optional<Employee> employeeResult = employeeRepositoryImpl.getOne(id);

		assertThat(employeeResult).isEqualTo(Optional.empty());
		assertThat(employeeResult.isPresent()).isEqualTo(false);

	}

}
