package com.cuemby.attendance.services;

import com.cuemby.attendance.services.config.ICRUDService;
import com.cuemby.attendance.v1.model.EmployeeDTO;

public interface IEmployeeService extends ICRUDService<EmployeeDTO> {

	void updateEstatusEmployeeInactive(String id);

	EmployeeDTO employeByIdentification(String identification);

}
