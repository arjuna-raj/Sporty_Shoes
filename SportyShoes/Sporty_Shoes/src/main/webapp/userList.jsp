<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.controller.User" %>
        <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
<%List<User> ss= (List<User>)request.getAttribute("data"); %>
<table border="1">

<tr><th>Uid</th><th>Name</th><th>Email</th></tr>
<%for(User s:ss){ %>
<tr><th><%=s.getUid() %></th><th><%=s.getName() %></th><th><%=s.getEmail() %></th></tr>
<%}%>
</table>
<form action="searchUser">
Search for a User: <input type="text" name="search" value="User Name">
<input type="submit" value="search">
</form>
<form action="adminDash">
<input type="submit" name="dash" value="Return to Dashboard">
</form>
</body>
</html>