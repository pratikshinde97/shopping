package com.example.shopping.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface BasicOperation<Entity,Dto> {
	
	@JsonIgnore
	public Entity getEntity(Entity entity);
	
	@JsonIgnore
	public Dto getDTO(Entity entity);
	

}
