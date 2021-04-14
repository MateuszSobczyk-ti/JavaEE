<%@ page import="model.Comment"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.security.Principal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<% List<Comment> listCom = (List<Comment>)request.getAttribute("listCom"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uzytkownik</title>
</head>
<body>
<div align="center">	
<%!Principal p;
String user_name;%>
<%p = request.getUserPrincipal();
if(p!=null){
user_name = p.getName();
session.setAttribute("user_name",user_name);}%>



<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="user.jsp">UserPage</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="logout.jsp">Logout</a>
    </li>
  </ul>
</nav><br>

<h1>Witaj na stronie, <%=user_name %></h1><br>

		<form action="TwitSerwlet" method="post">
			<input type="submit" class="btn btn-outline-secondary" name=submit value="Pokaz wpisy">
			<input type="submit" class="btn btn-outline-secondary" name=submit value="Dodaj wpis">
			<br>
			<br>
			<br>
		</form>


<p>
            <c:forEach var="val" items="${msg}">
                <c:out value="${val}"/>
                <br>
            </c:forEach>
        </p>
</div>
	<%!String action;%>
	<%action = (String)request.getAttribute("action");%>
	<%if("Pokaz wpisy".equals(action)){%>
		<%for (Comment cm : listCom) { %>
		<div class="container p-3 col-sm-5 bg-light border border-secondary">
			<h5><%=cm.getUser_name() %>,  <%= cm.getDate() %></h5>
			<%= cm.getContent() %><br><br>
		</div><br><br>
		<%}}%>


<div align="center">
<%if("Dodaj wpis".equals(action)){ %>
	<form action="TwitSerwlet" method="post">
		<textarea name="wpis" rows="6" cols="50" required placeholder="napisz cos..."></textarea><br><br>
		<input type="submit" class="btn btn-success" name="submit" value="Dodaj">
	</form>	
		<%} %>
</div>
</body>
</html>