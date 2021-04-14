<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rejestracja</title>
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
  </ul>
</nav>
<div align="center">
<br><br>
<p>
            <c:forEach var="err" items="${errMsg}">
                <c:out value="${err}"/>
                <br>
            </c:forEach>
        </p>
       <h1>Zarejestruj sie</h1>
	<form action="Serwlet" method="post">
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
		<input type="checkbox" name="agree"> Chcę otrzymywać na podany adres e-mail oraz numer telefonu komunikaty marketingowe 
		<br><br>
		<input type="submit" name="submit" value="Wyślij">
		<br>
		<br>
		<br>
		Zalogowanie się na swoje konto lub utworzenie go jest równoznaczne z akceptacją <a href="">Warunków</a> oraz <a href=""> Oświadczenia o ochronie prywatności</a>.
	</form>
</div>
</body>
</html>