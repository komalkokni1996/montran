package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="book_master")
public class BookMaster {
	
	@Id
	@Column(name="bookCode")
	private String bookCode;
	private String bookTitle;
	private String bookAuthor;
	private String isBookIssue;
	
	public BookMaster() {
		// TODO Auto-generated constructor stub
	}

	public BookMaster(String bookCode, String bookTitle, String bookAuthor, String isBookIssue) {
		super();
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.isBookIssue = isBookIssue;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getIsBookIssue() {
		return isBookIssue;
	}

	public void setIsBookIssue(String isBookIssue) {
		this.isBookIssue = isBookIssue;
	}

	
}
