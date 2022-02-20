<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.controller.*" %>
        <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Reports</title>
</head>
<body>
<%List<Purchase> ss= (List<Purchase>)request.getAttribute("data");%>
<h2>Filter By</h2>
<form action="dateFilter">
Date: <input type="submit" name="dateFilter" value="Date of Purchase">
</form>
<form action="categoryFilter">
Category:<input type="submit" name="categoryFilter" value="Category of Purchase">
</form>
<table border="1">

<tr><th>Rid</th><th>Purchased By</th><th>Category</th><th>Days since Order</th></tr>
<%
for(Purchase s:ss){
%>
<tr><th><%=s.getRid() %></th><th><%=s.getName() %></th><th><%=s.getCategory() %></th><th><%=s.getDate() %></th></tr>
<%}%>
</table>
<form action="adminDash">
<input type="submit" value="Return to Dashboard">
</form>

</body>
</html>