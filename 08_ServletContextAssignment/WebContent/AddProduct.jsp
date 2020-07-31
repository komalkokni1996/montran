<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h3>Add Product</h3>
	<%!ArrayList<String> list = new ArrayList<>(); %>
	<%!String ProductName = ""; %>
	<form action="" method="post">
	Product Name: <input type="text" name="txtProductName"><br><br>
	<input type="submit" value="PRINT">
	<hr>
	</form>
	<% String productName =request.getParameter("txtProductName");
	if(productName != null && !productName.equals("")){ //Checking Not NULL and String not Empty
		if(!list.contains(productName)){
			list.add(productName); //Adding object to List
			ProductName = list.toString(); //Converting to String
			application.setAttribute("Products",ProductName); //Application Object Creation
		}
	if(application.getAttribute("Products")!= null){ //Identifying Existing Created Application Object
		ProductName = application.getAttribute("Products").toString(); //Converting Application Object into String Type
		}
	}
	%>
	
	Suggestion:
	<%=ProductName %>  //Printing 
	
</body>
</html>