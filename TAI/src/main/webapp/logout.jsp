<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wyloguj</title>
</head>
<body>
<%
session.invalidate();
response.sendRedirect("register.jsp"); 
%>
</body>
</html>