package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="member_master")
public class MemberMaster {
	
	@Id
	@Column(name="memberCode")
	private String memberCode;
	private String memberType;
	private String name;
	private int bookIssueLimit;
	private int totalBookIssued;
	
	public MemberMaster() {
	
	}

	public MemberMaster(String memberCode, String memberType, String name, int bookIssueLimit, int totalBookIssued) {
		super();
		this.memberCode = memberCode;
		this.memberType = memberType;
		this.name = name;
		this.bookIssueLimit = bookIssueLimit;
		this.totalBookIssued = totalBookIssued;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBookIssueLimit() {
		return bookIssueLimit;
	}

	public void setBookIssueLimit(int bookIssueLimit) {
		this.bookIssueLimit = bookIssueLimit;
	}

	public int getTotalBookIssued() {
		return totalBookIssued;
	}

	public void setTotalBookIssued(int totalBookIssued) {
		this.totalBookIssued = totalBookIssued;
	}

	
}
