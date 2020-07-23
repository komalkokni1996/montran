package com.montran.pojo;

public class Book {
	private int bookID;
	private String name;
	private double price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bookID, String name, double price) {
		super();
		this.bookID = bookID;
		this.name = name;
		this.price = price;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", name=" + name + ", price=" + price + "]";
	}

}
