package com.niaa.expenses.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXPENSES")
public class Expenses {
	
	@Id
	@GeneratedValue
	@Column(name = "EXPENSE_ID", updatable = false, nullable = false)
	private long id;
	
	@Column(name = "AMOUNT")
	private double amount;
	
	@Column(name = "DATE")
	private Timestamp date;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "NOTES")
	private String notes;

	public long getId() {
		return id;
	}
	
	// no need for set Id as this will be a generated value

	/*public void setId(long id) {
		this.id = id;
	}*/

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
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

	
	
}
