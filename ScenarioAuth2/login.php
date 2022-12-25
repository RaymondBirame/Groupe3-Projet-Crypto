<?php
//Nous allons démarrer la session avant toute chose
session_start();
if (isset($_POST['boutton-valider'])) { // Si on clique sur le boutton , alors :
    //Nous allons verifiér les informations du formulaire
    if (isset($_POST['email']) && isset($_POST['mdp'])) { //On verifie ici si l'utilisateur a rentré des informations
        //Nous allons mettres l'email et le mot de passe dans des variables
        $email = $_POST['email'];
        $mdp = $_POST['mdp'];
        $erreur = "";
        //Nous allons verifier si les informations entrée sont correctes
        //Connexion a la base de données
        $nom_serveur = "localhost";
        $utilisateur = "root";
        $mot_de_passe = "";
        $nom_base_données = "mglsi_news";

        $con = mysqli_connect($nom_serveur, $utilisateur, $mot_de_passe, $nom_base_données, '3308');
        //requete pour selectionner  l'utilisateur qui a pour email et mot de passe les identifiants qui ont été entrées
        $req = mysqli_query($con, "SELECT * FROM user WHERE email = '$email' AND password ='$mdp' ");
        $req2 = mysqli_query($con, "SELECT * FROM user WHERE email = '$email' ");

        //$users = $req->fetchAll(PDO::FETCH_CLASS, 'user');
        $num_ligne2=  mysqli_num_rows($req2);
        $num_ligne = mysqli_num_rows($req); //Compter le nombre de ligne ayant rapport a la requette SQL
        if ($num_ligne > 0) {  //Si le nombre de ligne est > 0 , on sera redirigé vers la page...
            foreach (mysqli_fetch_all($req, MYSQLI_ASSOC) as $users) {
                if ($users['role'] == 'admin') {
                    header("Location:index.php?profil=administrateur");
                } else {
                    header("Location:index.php?profil=editeur");
                    //$_SESSION['email'] = $email ;}
                }
            }
        } 
        else{
            $erreur = "login ou Mots de passe incorrectes !";
        }
       if($num_ligne2 > 0) { //si non
            $erreur = " Mots de passe incorrectes !";
        }
    }
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualités</title>
    <link rel="stylesheet" href="assets/css/style2.css">
</head>

<body>
    <section>
        <h1> Connexion</h1>
        <?php
        if (isset($erreur)) { // si la variable $erreur existe , on affiche le contenu ;
            echo "<p class= 'Erreur'>" . $erreur . "</p>";
        }
        ?>
        <form action="" method="POST">
            <!--on ne mets plus rien au niveau de l'action , pour pouvoir envoyé les données  dans la même page -->
            <label>login</label>
            <input type="text" name="email">
            <label>Mots de Passe</label>
            <input type="password" name="mdp">
            <input type="submit" value="Valider" name="boutton-valider">
        </form>

    </section>
</body>

</html>