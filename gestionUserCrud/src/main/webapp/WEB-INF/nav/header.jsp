<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<script src="<c:url value='/js/script.js'/>"></script>
</head>
<body>
  <h2>Gestion des utiilisateurs </h2>
  <ul class="nav">
    <li><a href="<c:url value='/list'/>">Acceuil</a></li>
    <li><a href="<c:url value='/list'/>">Lister</a></li>
    <li><a href="<c:url value='/add'/>">Ajouter</a></li>
    <li><a href="<c:url value='/logout'/>">Deconnexion</a></li>
  </ul>
</body>
</html>