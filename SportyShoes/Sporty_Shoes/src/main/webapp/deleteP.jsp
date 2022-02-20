<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.controller.*" %>
        <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete a Shoe</title>
</head>
<body>
<%List<Product> pp= (List<Product>) request.getAttribute("data"); %>
<form action="deleteShoe">
Select Shoe Id:<select name="pid" id="pid">
<%for(Product p:pp) { %>
<option><%= p.getPid() %></option>
<% } %>
</select><br>
<input type="submit" value="Delete">
</form>
</body>
</html>