package com.cuemby.attendance.repositories;


import com.cuemby.attendance.domain.Employee;

public interface IEmployeeRepository extends ICustomCrudRepository<Employee, String>{
	
	public boolean employeeExist(String identification); 

}
