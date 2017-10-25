package com.cuemby.attendance.controllers.v1;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cuemby.attendance.services.impl.EmployeeServiceImpl;
import com.cuemby.attendance.v1.model.EmployeeDTO;
import com.cuemby.attendance.v1.model.EmployeeListDTO;


@RestController
@RequestMapping(EmployeeController.BASE_URL)
public class EmployeeController {
	
	public static final String BASE_URL = "/api/v1/employee";
	
	private final EmployeeServiceImpl employeeServiceImpl;
	
	public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
		this.employeeServiceImpl = employeeServiceImpl;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public EmployeeListDTO getallEmployees(){
		return new EmployeeListDTO(employeeServiceImpl.listAll());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeDTO saveEmployee(@Valid @RequestBody EmployeeDTO employeeDto){
		return employeeServiceImpl.create(employeeDto);
	}
	
	@PutMapping("/{id}/status")
	@ResponseStatus(HttpStatus.CREATED)
	public void inactiveUser(@PathVariable String id){
		
		employeeServiceImpl.updateEstatusEmployeeInactive(id);
	}
	
}
