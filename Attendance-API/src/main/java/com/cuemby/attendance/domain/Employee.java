package com.cuemby.attendance.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee  {
	
	public String id;
	private String identification;
	private String firstName;
	private String lastName;
	private Integer age;
	private String position;
	private Double salary;
	private LocalDate birthdate;	
	private LocalDate dateAdmission;
	private String status;
	
	public Employee() {
		this.id = UUID.randomUUID().toString();
	}
}
