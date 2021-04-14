<%@ page import="model.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<% List<User> listUsers = (List<User>)request.getAttribute("listUsers"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel administracyjny</title>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="user.jsp">UserPage</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="admin.jsp">AdminPage</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="logout.jsp">Logout</a>
    </li>
  </ul>
</nav>

<div align="center"><br>
	<h1>PANEL ADMINISTRACYJNY</h1>
	
	<form action="AdminSerwlet" method="post">
		<br>
		<input type="submit" class="btn btn-outline-secondary" name=submit value="Przegladaj uzytkownikow">
		<input type="submit" class="btn btn-outline-secondary" name=submit value="Edytuj uzytkownika">
		<input type="submit" class="btn btn-outline-secondary" name=submit value="Usun uzytkownika">
		<input type="submit" class="btn btn-outline-secondary" name=submit value="Dodaj uzytkownika">
		<input type="submit" class="btn btn-outline-secondary"  name=submit value="Dodaj admina">
		<br>
		<br>
		<br>
		</form>
		
		
		<%!String message; %>
		<%message = (String)request.getAttribute("message"); %>
		<%if(message!=null){ %>
		<%=message %><%} %>
		<%!String action;%>
		<%action = (String)request.getAttribute("action");%>
		<%if("Edytuj uzytkownika".equals(action)){ %>
		<h3>Edytuj uzytkownika </h3>
<p>
            <c:forEach var="err" items="${errMsg}">
                <c:out value="${err}"/>
                <br>
            </c:forEach>
        </p>
	<form action="AdminSerwlet" method="post">
		<input placeholder="Wpisz numer id" type="nnumber" name="id">
		<input placeholder="Haslo" type="password" name="password">
		<input placeholder="Email" type="email" name="email">
		<input placeholder="Phone" type="tel" name="phone">
		Panstwo:<select name="country" >
		<option value="Poland">Poland</option>
		<option value="Germany">Germany</option>
		<option value="Czech Republic">Czech Republic</option>
		<option value="Slovakia">Slovakia</option>
		<option value="Ukraine">Ukraine</option>
		<option value="Belarus">Belarus</option>
		<option value="Lithuania">Lithuania</option>
		<option value="Russia">Russia</option>
		</select>
		<input type="submit" name="submit" class="btn btn-outline-warning" value="Zapisz">
		<br><br>
	</form>	
		<%} %>
		
		
		<%if("Usun uzytkownika".equals(action)){ %>
		<h3>Wpisz numer id uzytkownika do usuniecia </h3>
<p>
            <c:forEach var="err" items="${errMsg}">
                <c:out value="${err}"/>
                <br>
            </c:forEach>
        </p>
	<form action="AdminSerwlet" method="post">
		<input type="text" name="id">
		<input type="submit" name="submit" class="btn btn-outline-danger" value="Usun">
		<br><br>
	</form>	
		<%} %>
		
		
		<%if("Dodaj uzytkownika".equals(action)){ %>
		<h3>Dodaj nowego uzytkownika</h3>
	<p>
            <c:forEach var="err" items="${errMsg}">
                <c:out value="${err}"/>
                <br>
            </c:forEach>
        </p>
	<form action="AdminSerwlet" method="post">
		<input placeholder="Nazwa" type="text" name="name">
		<br><br>
		<input placeholder="Haslo" type="password" name="password">
		<br><br>
		<input placeholder="Email" type="email" name="email">
		<br><br>
		<input placeholder="Phone" type="tel" name="phone">
		<br><br>
		Panstwo:<select name="country" >
		<option value="Poland">Poland</option>
		<option value="Germany">Germany</option>
		<option value="Czech Republic">Czech Republic</option>
		<option value="Slovakia">Slovakia</option>
		<option value="Ukraine">Ukraine</option>
		<option value="Belarus">Belarus</option>
		<option value="Lithuania">Lithuania</option>
		<option value="Russia">Russia</option>
		</select>
		<br><br>
		<input type="checkbox" name="agree">Chcę otrzymywać na podany adres e-mail oraz numer telefonu komunikaty marketingowe 
		<br><br>
		<input type="submit" name="submit" class="btn btn-outline-success" value="Dodaj">
		<br>
		<br>
	</form><%} %>
	
	
	<%if("Dodaj admina".equals(action)){ %>
		<h3>Dodaj nowego admina</h3>
	<p>
            <c:forEach var="err" items="${errMsg}">
                <c:out value="${err}"/>
                <br>
            </c:forEach>
        </p>
	<form action="AdminSerwlet" method="post">
		<input placeholder="Nazwa" type="text" name="name">
		<br><br>
		<input placeholder="Haslo" type="password" name="password">
		<br><br>
		<input placeholder="Email" type="email" name="email">
		<br><br>
		<input placeholder="Phone" type="tel" name="phone">
		<br><br>
		Panstwo:<select name="country" >
		<option value="Poland">Poland</option>
		<option value="Germany">Germany</option>
		<option value="Czech Republic">Czech Republic</option>
		<option value="Slovakia">Slovakia</option>
		<option value="Ukraine">Ukraine</option>
		<option value="Belarus">Belarus</option>
		<option value="Lithuania">Lithuania</option>
		<option value="Russia">Russia</option>
		</select>
		<br><br>
		<input type="checkbox" name="agree">Chcę otrzymywać na podany adres e-mail oraz numer telefonu komunikaty marketingowe 
		<br><br>
		<input type="submit" name="submit" class="btn btn-outline-success" value="DodajAd">
		<br>
		<br>
	</form><%} %>
		
		<%if("Przegladaj uzytkownikow".equals(action) || "Edytuj uzytkownika".equals(action) || "Usun uzytkownika".equals(action)){ %>
		<%!int i; %><%i=1; %>
		<table class="table table-hover table-striped">
			<tr>
				<td> id</td>
				<td> nazwa</td>
				<td> haslo</td>
				<td> email</td>
				<td> Nr telefonu</td>
				<td> Panstwo</td>
			</tr>
			<%for (User us : listUsers) { %>
			<tr>
				<td><%=i++ %></td>
				<td><%= us.getUser_name() %></td>
				<td><%= us.getPassword() %></td>
				<td><%= us.getEmail() %></td>
				<td><%= us.getPhone() %></td>
				<td><%= us.getCc() %></td>
			</tr>
			<%} %>
		</table>
		<%} %>

	<br>
</div>
</body>
</html>