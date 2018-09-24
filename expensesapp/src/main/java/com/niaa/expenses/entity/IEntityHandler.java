package com.niaa.expenses.entity;

public interface IEntityHandler {
	
	public Object findAll(String resourceName);
	
	public Object find(String resourceName, String resourceId);

}
