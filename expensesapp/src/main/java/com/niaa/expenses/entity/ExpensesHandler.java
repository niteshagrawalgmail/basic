package com.niaa.expenses.entity;

public class ExpensesHandler implements IEntityHandler{

	@Override
	public Object findAll(String resourceName) {
		return new Service().getExpenses();
	}

	@Override
	public Object find(String resourceName, String resourceId) {
		return new Service().getExpense(resourceId);
	}

}
