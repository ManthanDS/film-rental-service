package com.sprintProject.data.dto;

public class FilmAmount {

	String title;
	double amount;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public FilmAmount(String title, double amount) {
		super();
		this.title = title;
		this.amount = amount;
	}
	
}
