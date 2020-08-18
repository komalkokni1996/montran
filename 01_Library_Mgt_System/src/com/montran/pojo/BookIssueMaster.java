package com.montran.pojo;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="book_issue_returns")
public class BookIssueMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="issueSerialNumber")
	private int issueSerialNumber;
	private LocalDate dateOfIssue;
	private LocalDate dueDateOfReturn;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bookCode")
	private BookMaster book;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="memberCode")
	private MemberMaster member;
	
	public BookIssueMaster() {
		// TODO Auto-generated constructor stub
	}

	public BookIssueMaster(int issueSerialNumber, LocalDate dateOfIssue, LocalDate dueDateOfReturn, BookMaster book,
			MemberMaster member) {
		super();
		this.issueSerialNumber = issueSerialNumber;
		this.dateOfIssue = dateOfIssue;
		this.dueDateOfReturn = dueDateOfReturn;
		this.book = book;
		this.member = member;
	}

	public int getIssueSerialNumber() {
		return issueSerialNumber;
	}

	public void setIssueSerialNumber(int issueSerialNumber) {
		this.issueSerialNumber = issueSerialNumber;
	}

	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public LocalDate getDueDateOfReturn() {
		return dueDateOfReturn;
	}

	public void setDueDateOfReturn(LocalDate dueDateOfReturn) {
		this.dueDateOfReturn = dueDateOfReturn;
	}

	public BookMaster getBook() {
		return book;
	}

	public void setBook(BookMaster book) {
		this.book = book;
	}

	public MemberMaster getMember() {
		return member;
	}

	public void setMember(MemberMaster member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "BookIssueMaster [issueSerialNumber=" + issueSerialNumber + ", dateOfIssue=" + dateOfIssue
				+ ", dueDateOfReturn=" + dueDateOfReturn + ", book=" + book + ", member=" + member + "]";
	}
	
	
	
}
