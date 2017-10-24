package com.cuemby.attendance.v1.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {
	private String identification;
	private String firstName;
	private String lastName;
	private Integer age;
	private String position;
	private Double salary;
	private LocalDate birthdate;	
	private LocalDate dateAdmission;
	private String status;
}
