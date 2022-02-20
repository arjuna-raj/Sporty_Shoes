<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.controller.*" %>
        <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new Shoe</title>
</head>
<body>
<%List<Category> pp= (List<Category>) request.getAttribute("data"); %>
<form action="addShoe">
New shoe name:<input type="text" name="shoeName" value="New Shoe Name"><br>
Shoe Category:<select name="category" id="category">
<%for(Category p:pp) { %>
<option><%= p.getName() %></option>
<% } %>
</select><br>
<input type="submit" value="add shoe">
</form>
</body>
</html>