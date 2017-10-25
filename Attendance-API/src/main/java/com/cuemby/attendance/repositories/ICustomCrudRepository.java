package com.cuemby.attendance.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface ICustomCrudRepository<T, S> {
	
	Map<S,T> findAll();

//	List<T> findAllById(Iterable<T> ids);

	Map<S,T> saveAll(Iterable<T> entities);

	T save(T entity);

	T update(T entity);

	Optional<T> getOne(S id);

}
