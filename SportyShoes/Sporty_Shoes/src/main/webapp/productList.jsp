<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.controller.*" %>
        <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
<%List<Product> ss= (List<Product>)request.getAttribute("data"); %>
<table border="1">

<tr><th>Pid</th><th>Name</th><th>Category</th></tr>
<%for(Product s:ss){ %>
<tr><th><%=s.getPid() %></th><th><%=s.getName() %></th><th><%=s.getCategory() %></th></tr>
<%}%>
</table>
<form action="manageProducts">
Manage Products: <input type="submit" name="manage" value="Manage">
</form>
<form action="adminDash">
<input type="submit" value="return to dash">
</form>
</body>
</html>