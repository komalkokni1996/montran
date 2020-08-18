package com.montran.form;

import java.time.LocalDate;

import org.apache.struts.action.ActionForm;

import com.montran.pojo.BookMaster;
import com.montran.pojo.MemberMaster;

public class BookIssueMasterForm extends ActionForm{
	
	private int issueSerialNumber;
	private String memberCode;
	private String name;
	private String bookCode;
	private String bookTitle;
	private String bookAuthor;
	private LocalDate dateOfIssue;
	private LocalDate dueDateOfReturn;
	
	private BookMaster book;
	private MemberMaster member;
	
	public BookIssueMasterForm() {
		System.out.println("In DEFAULT Constructor of BookIssueMasterForm");
	}

	public BookIssueMasterForm(int issueSerialNumber, String memberCode, String name, String bookCode, String bookTitle,
			String bookAuthor, LocalDate dateOfIssue, LocalDate dueDateOfReturn, BookMaster book, MemberMaster member) {
		super();
		this.issueSerialNumber = issueSerialNumber;
		this.memberCode = memberCode;
		this.name = name;
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.dateOfIssue = dateOfIssue;
		this.dueDateOfReturn = dueDateOfReturn;
		this.book = book;
		this.member = member;
	}

	public int getIssueSerialNumber() {
		System.out.println("In BookIssueMasterForm's getIssueSerialNumber()");
		return issueSerialNumber;
	}

	public void setIssueSerialNumber(int issueSerialNumber) {
		System.out.println("In BookIssueMasterForm's setIssueSerialNumber()");
		this.issueSerialNumber = issueSerialNumber;
	}

	public String getMemberCode() {
		System.out.println("In BookIssueMasterForm's getMemberCode()");
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		System.out.println("In BookIssueMasterForm's setMemberCode()");
		this.memberCode = memberCode;
	}

	public String getName() {
		System.out.println("In BookIssueMasterForm's  getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("In BookIssueMasterForm's  setName()");
		this.name = name;
	}

	public String getBookCode() {
		System.out.println("In BookIssueMasterForm's  getBookCode()");
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		System.out.println("In BookIssueMasterForm's  setBookCode()");
		this.bookCode = bookCode;
	}

	public String getBookTitle() {
		System.out.println("In BookIssueMasterForm's  getBookTitle()");
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		System.out.println("In BookIssueMasterForm's  setBookTitle()");
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		System.out.println("In BookIssueMasterForm's  getBookAuthor()");
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		System.out.println("In BookIssueMasterForm's  setBookAuthor()");
		this.bookAuthor = bookAuthor;
	}

	public LocalDate getDateOfIssue() {
		System.out.println("In BookIssueMasterForm's  getDateOfIssue()");
		return dateOfIssue;
	}

	public void setDateOfIssue(LocalDate dateOfIssue) {
		System.out.println("In BookIssueMasterForm's  setDateOfIssue()");
		this.dateOfIssue = dateOfIssue;
	}

	public LocalDate getDueDateOfReturn() {
		return dueDateOfReturn;
	}

	public void setDueDateOfReturn(LocalDate dueDateOfReturn) {
		this.dueDateOfReturn = dueDateOfReturn;
	}

	public BookMaster getBook() {
		System.out.println("In BookIssueMasterForm's getBook()");
		return book;
	}

	public void setBook(BookMaster book) {
		System.out.println("In BookIssueMasterForm's setBook()");
		this.book = book;
	}

	public MemberMaster getMember() {
		System.out.println("In BookIssueMasterForm's getMember()");
		return member;
	}

	public void setMember(MemberMaster member) {
		System.out.println("In BookIssueMasterForm's setMember()");
		this.member = member;
	}


}
