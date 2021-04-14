<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zaloguj się</title>
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
      <a class="nav-link" href="register.jsp">Zarejestruj sie</a>
    </li>
  </ul>
</nav>
<div align="center">
<br>
	<h1>Zaloguj się</h1>
	<form action="j_security_check" method="post">
		<input type="text" placeholder="Login" name="j_username">
		<br><br>
		<input type="password" placeholder="Password" name="j_password">
		<br><br>
		<input type="submit" value="Zaloguj">
	</form>
</div>
</body>
</html>