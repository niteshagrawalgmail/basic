package com.niaa.expenses.entity;

public class EntityHandlerFactory {
	
	private final static String EXPENSES = "expenses";
	
	public static IEntityHandler getEntityHandler(String entityName) {
		if(entityName.equalsIgnoreCase(EXPENSES)) {
			return new ExpensesHandler();
		}
		return null;
	}

}
