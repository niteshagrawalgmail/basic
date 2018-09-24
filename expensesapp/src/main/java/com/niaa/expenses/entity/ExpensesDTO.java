package com.niaa.expenses.entity;

public class ExpensesDTO {
	
	private int id;
	private double amount;
	private long date;
	private String currency;
	private String category;
	private String notes;


	public ExpensesDTO(int id, double amount, long date, String currency, String category, String notes) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.currency = currency;
		this.category = category;
		this.notes = notes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Override
	public String toString() {
		return "Expenses [id=" + id + ", amount=" + amount + ", date=" + date + ", currency=" + currency + ", category="
				+ category + ", notes=" + notes + "]";
	}

}
