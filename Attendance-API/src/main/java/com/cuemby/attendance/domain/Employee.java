package com.cuemby.attendance.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends Entity {
	
	
	private String identification;
	
	
	private String firstName;
	
	
	private String lastName;
	
	
	private Integer age;
	
	
	private String position;
	private Double salary;
	
	
	private Date birthdate;	
	private Date dateAdmission;
	
	@NotBlank
	private String status;
	
}
