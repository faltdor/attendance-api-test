package com.cuemby.attendance.services.config;

import java.util.List;

public interface ICRUDService<T> {
	List<?> listAll();
	
	T getById(Integer id);
	
	T createNewEmployee(T domainObject);
	
	void delete(Integer id);
}
