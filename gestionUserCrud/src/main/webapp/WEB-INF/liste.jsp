
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="nav/header.jsp" %>

<h1 id="titre-principal">Liste des utilisateurs</h1>
 <div id="corps">
<c:choose>
	<c:when test="${empty utilisateurs }">
		<p>La liste des utilisateurs est vide</p>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>ID</th>
		    <th>Nom</th>
		    <th>prenom</th>
		    <th>Login</th>
		    <th>Password</th>
		    <th colspan="4">Actions</th>
		  </tr>
		  	<c:forEach var="utilisateur" items="${utilisateurs }">
		  		<tr>
		    	  <td><c:out value="${utilisateur.id }" /></td>
		    	  <td><c:out value="${utilisateur.nom}" /></td>
		    	  <td><c:out value="${utilisateur.prenom }" /></td>
		    	  <td><c:out value="${utilisateur.login }" /></td>
		    	  <td><c:out value="${utilisateur.password }" /></td>
		    	  <td> <a href="update?id=${utilisateur.id }">Modifier</a>  </td>
		    	  <td><a href="Delete?id=${utilisateur.id }" onclick="return confirmerSuppression()">Supprimer</a></td>
		  		</tr>
		  	</c:forEach>
		</table>		
	</c:otherwise>
</c:choose>

 </div>