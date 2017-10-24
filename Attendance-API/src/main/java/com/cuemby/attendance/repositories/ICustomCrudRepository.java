package com.cuemby.attendance.repositories;

import java.util.List;
import java.util.Optional;



public interface ICustomCrudRepository <T, ID> {
		List<T> findAll();

		List<T> findAllById(Iterable<ID> ids);

		
		List<T> saveAll(Iterable<T> entities);

		
		Optional<T> save(T entity);

		
		void deleteInBatch(Iterable<T> entities);

		
		void deleteAllInBatch();

		
		Optional<T> getOne(ID id);

}
