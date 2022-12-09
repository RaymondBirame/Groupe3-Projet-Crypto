<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="nav/header.jsp" %>

 <div>
   <p class="erreur">${statusMessage}</p>

   <form action="add" method="post">
	   <fieldset style="width:500px">
		    <legend style="height:-20px">Ajout utilisateur</legend>
		    <label>Prenom</label><br>
		    <input type="text" name="prenom" >
		    <span class="erreur">${erreurs.prenom}</span><br><br>
		    
		    <label>Nom</label><br>
		    <input type="text" name="nom">
		    <span class="erreur">${erreurs.nom}</span><br><br>
		    
		    <label>Login</label><br>
		    <input type="text" name="login">
		    <span class="erreur">${erreurs.login }</span><br><br>
		    
		    <label>Mot de passe </label><br>
		    <input type="password" name="password" >
		    <span class="erreur">${erreurs.password }</span><br><br>
		    
		    <label>Confirmation du Passsword</label><br>
		    <input type="password" name="passwordBis">
		    <span class="erreur">${erreurs.passwordBis }</span> <br><br><br>
		    
		    <input type="submit" >
	  </fieldset>
  </form>  
  </div>