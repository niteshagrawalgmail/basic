package com.niaa.expenses.path.processor;

public class PathInfo {
	
	private boolean isCollection = false;
	private String resourceName = null;
	private String resourceId = null;
	
	
	public boolean isCollection() {
		return isCollection;
	}
	public void setCollection(boolean isCollection) {
		this.isCollection = isCollection;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
}
