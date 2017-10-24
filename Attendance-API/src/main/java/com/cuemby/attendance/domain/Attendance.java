package com.cuemby.attendance.domain;

import java.util.Date;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Attendance extends Entity{

	private String id;

	private String employeeId;

	private Date currentDateAssistance;
	
	public Attendance() {
		super();
	}
}
