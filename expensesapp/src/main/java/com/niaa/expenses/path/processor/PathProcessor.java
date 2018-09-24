package com.niaa.expenses.path.processor;

public class PathProcessor {

	public static PathInfo process(String path) {

		PathInfo pathInfo = new PathInfo();

		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		if (path.endsWith("/")) {
			path = path.substring(0, path.length() - 1);			
		}
		String[] tokens = path.split("/");
		if (tokens.length % 2 == 0) {
			pathInfo.setCollection(true);
			String resourceName = tokens[tokens.length - 1];
			pathInfo.setResourceName(resourceName);
		}else {
			pathInfo.setCollection(false);
			String resourceID = tokens[tokens.length - 1];
			pathInfo.setResourceId(resourceID);
			String resourceName = tokens[tokens.length - 2];
			pathInfo.setResourceName(resourceName);
		}
		
		

		return pathInfo;
	}
}
