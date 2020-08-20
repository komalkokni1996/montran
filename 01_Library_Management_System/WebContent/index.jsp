<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>page1_Issue_Book_List</title>
</head>
<body>
	<h3>Issued Book List</h3>
	<hr>
	<br>
	<html:form action="bookIssueMasterAction">
		<table border=1>
			<tr>
				<th>Issue Serial Number</th>
				<th>Member Code</th>
				<th>Member Name</th>
				<th>Book Code</th>
				<th>Book Title</th>
				<th>Book Author</th>
				<th>Date Of Issue</th>
				<th>Due Date Of Return</th>
			</tr>
			<logic:iterate name="books" id="book">
				<tr>
					<td><bean:write name="book" property="issueSerialNumber" /></td>
					<td><bean:write name="book" property="member.memberCode" /></td>
					<td><bean:write name="book" property="member.name" /></td>
					<td><bean:write name="book" property="book.bookCode" /></td>
					<td><bean:write name="book" property="book.bookTitle" /></td>
					<td><bean:write name="book" property="book.bookAuthor" /></td>
					<td><bean:write name="book" property="dateOfIssue" /></td>
					<td><bean:write name="book" property="dueDateOfReturn" /></td>
				</tr>
			</logic:iterate> 

			<tr>
				<td><a href="newBookForm.jsp">Issue New Book</a></td>
				<td><a href="updateBookForm.jsp">Update</a></td>
				<td><a href="deleteBookForm.jsp">Delete</a></td>
			</tr>
		</table>
	</html:form>
</body>
</html>