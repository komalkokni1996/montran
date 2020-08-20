<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Book Form</title>
</head>
<body>
	<h3>Delete Book Form</h3>
	<hr>
	<html:form action="deleteBookAction" method="post">
	Enter Issue Serial Number
			<html:text property="issueSerialNumber" size="20" maxlength="20" />
		<br>
		<br>
		<html:submit>DELETE BOOK</html:submit>
	</html:form>
</body>
</html>