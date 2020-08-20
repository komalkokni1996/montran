<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Book Issue Form</title>
</head>
<body>
	<h3>New Book Issue Form</h3>
	<hr>
</body>
<html:form action="/newBookAction" method="post">
	<table border=1>
		<tr>
			<th>Issue Serial Number</th>
			<td><html:text property="issueSerialNumber" size="20" maxlength="20" /></td>
		</tr>
		<tr>
			<th>Member Code</th> 
			<td><html:text property="memberCode" size="20" maxlength="20" /></td>
			<td><html:submit property="member" value="getMember">GET Member Details</html:submit></td>
		</tr>
		<tr>
			<th>Member Name</th>
			<td><html:text property="name" size="20" maxlength="20" /></td>
		</tr>
		<tr>
			<th>Book Code</th>
			<td><html:text property="bookCode" size="20" maxlength="20" /></td>
			<td><html:submit property="book" value="getBook">GET Book Details</html:submit></td>
		</tr>
		<tr>
			<th>Book Title</th>
			<td><html:text property="bookTitle" size="20" maxlength="20" /></td>
		</tr>	
		<tr>
			<th>Book Author</th>
			<td><html:text property="bookAuthor" size="20" maxlength="20" /></td>
		</tr>
		<tr>
			<th>Date Of Issue</th>
			<td><html:text property="dateOfIssue" size="20" maxlength="20" /></td>
		</tr>
		<tr>
			<th>Due Date Of Return</th>
			<td><html:text property="dueDateOfReturn" size="20" maxlength="20" /></td>
		</tr>	
	</table><br><br>
	<html:submit property="issue" value="issueBook">ISSUE BOOK</html:submit>
</html:form>

</html>