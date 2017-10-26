package com.cuemby.attendance.services;

import java.util.List;

import com.cuemby.attendance.v1.model.AttendanceDTO;
import com.cuemby.attendance.v1.model.AttendanceEmployeeDTO;
import com.cuemby.attendance.v1.model.AttendanceFilterDTO;

public interface IAttendanceService {
	
	public AttendanceDTO create(AttendanceDTO domainObject);

	public List<AttendanceDTO> listAll();

	public List<AttendanceEmployeeDTO> listEmployeeAttendance(AttendanceFilterDTO attendanceFilter);
}
  