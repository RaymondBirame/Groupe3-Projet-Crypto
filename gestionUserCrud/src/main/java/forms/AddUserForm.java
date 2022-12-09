package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import dao.Userdao;
import user.User;

public class AddUserForm {
	
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	private static final String ECHEC_AJOUT_MESSAGE = "Echec de l'ajout";
	private static final String SUCCES_AJOUT_MESSAGE = "Ajout effectué";
	private static final String EMPTY_FIELD_ERROR_MESSAGE = "Vous devez renseignez ce champ";
	private static final String DIFFERENT_PASSWORD_ERROR_MESSAGE = "Les mots de passes ne sont pas conformes";
	
	private HttpServletRequest request;
	private Map<String,String> erreurs;
	private User user;
	private boolean status;
	private String statusMessage;
	
	public AddUserForm(HttpServletRequest request) {
		this.request = request;
		this.status = false;
		this.statusMessage = ECHEC_AJOUT_MESSAGE;
		this.erreurs = new HashMap<String,String>();
	}
	

	public boolean ajouter() 
	{
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		
		this.user = new User(nom,prenom,login,password);
		
		this.valider(CHAMP_NOM,CHAMP_PRENOM,CHAMP_LOGIN,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		this.validerPassword();
		
		if(this.erreurs.isEmpty()) {
			Userdao.insertUser(user);
			this.status = true;
			this.statusMessage = SUCCES_AJOUT_MESSAGE;
		}
		return this.status;
	}
	
	public String getParameter(String parametre) 
	{
		String valeur = this.request.getParameter(parametre);
		return (valeur == null  || valeur.trim().isEmpty()) ? null : valeur.trim(); 
	}
	
	public void valider(String...champs ) {
		for(String champ:champs) {
			if(this.getParameter(champ) == null) {
				erreurs.put(champ,EMPTY_FIELD_ERROR_MESSAGE);
			}
		}
		
	}
	
	public void validerPassword() {
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordBis = this.getParameter(CHAMP_PASSWORD_BIS);
		
		if(password != null && !password.equals(passwordBis)) {
			erreurs.put(CHAMP_PASSWORD, DIFFERENT_PASSWORD_ERROR_MESSAGE);
			erreurs.put(CHAMP_PASSWORD_BIS, DIFFERENT_PASSWORD_ERROR_MESSAGE);
		}
	}

	public static String getChampNom() {
		return CHAMP_NOM;
	}

	public static String getChampPrenom() {
		return CHAMP_PRENOM;
	}

	public static String getChampLogin() {
		return CHAMP_LOGIN;
	}

	public static String getChampPassword() {
		return CHAMP_PASSWORD;
	}

	public static String getChampPasswordBis() {
		return CHAMP_PASSWORD_BIS;
	}

	public static String getEchecAjoutMessage() {
		return ECHEC_AJOUT_MESSAGE;
	}

	public static String getSuccesAjoutMessage() {
		return SUCCES_AJOUT_MESSAGE;
	}

	public static String getEmptyFieldErrorMessage() {
		return EMPTY_FIELD_ERROR_MESSAGE;
	}

	public static String getDifferentPasswordErrorMessage() {
		return DIFFERENT_PASSWORD_ERROR_MESSAGE;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public User getUser() {
		return user;
	}

	public boolean isStatus() {
		return status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}
	
	
}
