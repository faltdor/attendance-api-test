package com.cuemby.attendance.domain;

import java.util.UUID;

import lombok.Data;

@Data
public abstract class Entity {
	
	public String id;
	
	public Entity() {
		this.id = UUID.randomUUID().toString();
	}
	
}