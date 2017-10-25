package com.cuemby.attendance.v1.model.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cuemby.attendance.domain.Employee;
import com.cuemby.attendance.v1.model.EmployeeDTO;

@Mapper
public interface IEmployeeMapper {
	
	IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);
	
	EmployeeDTO employeeToEmployeeDTO(Employee employee);
	
	@InheritInverseConfiguration
	Employee employeeDTOToEmployee(EmployeeDTO employeeDto);
}
