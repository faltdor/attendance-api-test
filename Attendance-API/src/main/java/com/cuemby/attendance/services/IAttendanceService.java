package com.cuemby.attendance.services;

import java.util.List;

import com.cuemby.attendance.v1.model.AttendanceDTO;

public interface IAttendanceService {
	
	public AttendanceDTO create(AttendanceDTO domainObject);

	public List<AttendanceDTO> listAll();
}
