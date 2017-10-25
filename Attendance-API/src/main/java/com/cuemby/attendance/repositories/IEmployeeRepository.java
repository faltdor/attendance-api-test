package com.cuemby.attendance.repositories;


import java.util.List;

import com.cuemby.attendance.domain.Employee;

public interface IEmployeeRepository extends ICustomCrudRepository<Employee, String>{
	
	public boolean employeeExist(String identification);
	public List<Employee> findAllByStatus(String status);

}
