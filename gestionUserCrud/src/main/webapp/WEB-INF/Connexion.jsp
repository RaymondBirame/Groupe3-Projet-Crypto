<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='css/style.css'/>">
</head>
<body>

	<form method="post" action="login">
	<h1 id="connexion">Connexion</h1>
	
		<div id="formlogin" style=" padding-left: 600px;">
			<c:if test="${ConnexionFailed == true }">
				<p class="erreur">Login et/ou mot de passe incorrect</p>
			</c:if>
			<label>&nbsp;Login</label><br>
			<input type="text" name="login" value="${login }"><br><br>
			<label>Mot de passe </label><br>
			<input type="password" name="password"> <br><br><br>
			<input type="submit" style=" background-color:blue; color:white;">
		</div>
	</form>
</body>
</html>