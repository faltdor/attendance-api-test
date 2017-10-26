package com.cuemby.attendance.v1.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class AttendanceFilterDTO {
	
	private Date dateInit;
	private Date dateEnd;
}
