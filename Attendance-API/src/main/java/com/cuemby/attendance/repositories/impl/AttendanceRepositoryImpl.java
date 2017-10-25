package com.cuemby.attendance.repositories.impl;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.cuemby.attendance.domain.Attendance;
import com.cuemby.attendance.domain.factories.UUIDCreator;
import com.cuemby.attendance.repositories.IAttendanceRespository;

@Component
public class AttendanceRepositoryImpl implements IAttendanceRespository {
	
	private Map<String,Attendance> attendanceList;
	
	
	public AttendanceRepositoryImpl() {
		this.attendanceList = new ConcurrentHashMap<>();
	}

	@Override
	public Map<String, Attendance> findAll() {
		return this.attendanceList;
	}

	@Override
	public Map<String, Attendance> saveAll(Iterable<Attendance> entities) {
		entities.forEach(attendance ->{
			save(attendance);			
		});
		
		return this.attendanceList;
	}

	@SuppressWarnings("static-access")
	@Override
	public Attendance save(Attendance entity) {
			entity.setId(UUIDCreator.getInstance().randomUUID());
			this.attendanceList.put(entity.getId(), entity);
			
		return entity;
	}

	@Override
	public Attendance update(Attendance entity) {
		this.attendanceList.put(entity.getId(), entity);
		return entity;
	}

	@Override
	public Optional<Attendance> getOne(String id) {
		return this.attendanceList.values().stream().
				 filter(e-> e.getId().equalsIgnoreCase(id))
				 .findFirst();
	}

}
