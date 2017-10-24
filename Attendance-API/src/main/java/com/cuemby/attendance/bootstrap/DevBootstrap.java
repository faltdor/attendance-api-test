package com.cuemby.attendance.bootstrap;

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
		employeeRepositoryImpl.saveAll(getAllEmployees());
	}

	private List<Employee> getAllEmployees() {
		
		Employee employee1 = new Employee();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");

		Employee employee2 = new Employee();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");

		Employee employee3 = new Employee();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");

		return Arrays.asList(employee1, employee2, employee3);

	}

}
