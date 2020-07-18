package com.montran.pojo;

public class Book {

	private int bookNumber;
	private String bookTitle;
	private double price;
	
	public double total_cost(int n) {
		
		 return n * price;
	}
	
	public void input(int bookNumber, String bookTitle, double price) {
		this.bookNumber = bookNumber;
		this.bookTitle = bookTitle;
		this.price = price;
	}

	public double purchase(int n) {
		return total_cost(n);
	}
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookTitle=" + bookTitle + ", price=" + price + "]";
	}
}
