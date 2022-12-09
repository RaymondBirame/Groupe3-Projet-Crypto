<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="nav/header.jsp" %>


<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
 <div id="corps">
<h1 id="titre-principal">Modification d'un utilisateur</h1>
 <form action="" method="post">
   <fieldset>
     <legend>Modification d'un utilisateur</legend>
     <input type="hidden" name="id" value="${utilisateur.id }"/>
    <label>Prenom</label><br>
    <input type="text" name="prenom" value="${utilisateur.prenom }"><br>
    <label>Nom</label><br>
    <input type="text" name="nom" value="${utilisateur.nom }"><br>
    <label>Login</label><br>
    <input type="text" name="login" value="${utilisateur.login }"><br>
    <label>Passsword</label><br>
    <input type="password" name="password" value="${utilisateur.password }"><br><br>
    <input type="submit" >
  </fieldset>
  </form>
   
<%@include file="inc/footer.jsp" %>