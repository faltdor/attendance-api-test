package com.cuemby.attendance.bootstrap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.cuemby.attendance.domain.Employee;
import com.cuemby.attendance.repositories.impl.EmployeeRepositoryImpl;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent>{
	
	private final EmployeeRepositoryImpl employeeRepositoryImpl;
	
	@Autowired
	public DevBootstrap(EmployeeRepositoryImpl employeeRepositoryImpl) {
		this.employeeRepositoryImpl = employeeRepositoryImpl;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		log.debug("Saving data to Dababase ");
//		try {
//			employeeRepositoryImpl.saveAll(getAllEmployees());
//		} catch (ParseException e) {
//			 log.error(e.getMessage());
//		}
	}

	private List<Employee> getAllEmployees() throws ParseException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Employee employee1 = new Employee();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");
		employee1.setLastName("Empl last name");
		employee1.setAge(10);
		employee1.setPosition("Mannager");
		employee1.setSalary(600000.0);
		String birthdate = "2016-08-01";
		employee1.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse(birthdate));
		employee1.setStatus("Active");
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Employee 1");
		employee2.setIdentification("1234567");
		employee2.setLastName("Empl last name");
		employee2.setAge(10);
		employee2.setPosition("Mannager");
		employee2.setSalary(600000.0);
		employee2.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse(birthdate));
		employee2.setStatus("Active");
		
		Employee employee3 = new Employee();
		employee3.setFirstName("Employee 1");
		employee3.setIdentification("1234567");
		employee3.setLastName("Empl last name");
		employee3.setAge(10);
		employee3.setPosition("Mannager");
		employee3.setSalary(600000.0);
		employee3.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse(birthdate));
		employee3.setStatus("inactive");
		return Arrays.asList(employee1, employee2, employee3);

	}

}
