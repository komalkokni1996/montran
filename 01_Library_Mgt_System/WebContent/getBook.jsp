<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GetBook By ID</title>
</head>
<body>
	<html:form action="getBookByIdAction" method="post">
		<h3>Get book</h3>
		<hr>
			Issue Serial Number
			<html:text property="issueSerialNumber" size="20" maxlength="20" />
		<br>
		<br>
		<html:submit>GET BOOK</html:submit>
	

	</html:form>

</body>
</html>