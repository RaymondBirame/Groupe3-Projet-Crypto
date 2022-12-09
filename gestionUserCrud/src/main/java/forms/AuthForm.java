package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.Userdao;
import user.User;

public class AuthForm {
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String ERROR_MESSAGE = "Incorrect";
	

	private HttpServletRequest request;
	private Map<String,String> erreurs;
	private boolean status;
	private String statusMessage;
	
	public AuthForm(HttpServletRequest request) {
		this.request = request;
		this.status = false;
		this.statusMessage = ERROR_MESSAGE;
		this.erreurs = new HashMap<String,String>();
	}
	
	public boolean auth() 
	{
		String login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		
		
		this.valider(CHAMP_LOGIN,CHAMP_PASSWORD);
	
			User user = null;
			
			user = Userdao.getUserBylogin(login, password);
			
			if(user != null ) {
				this.status = true;
				return status;
			}else {
				return this.status;
			}
	}
	

	public String getParameter(String parametre) 
	{
		String valeur = this.request.getParameter(parametre);
		return (valeur == null  || valeur.trim().isEmpty()) ? null : valeur.trim(); 
	}
	
	public void valider(String...champs ) {
		for(String champ:champs) {
			if(this.getParameter(champ) == null) {
				erreurs.put(champ,ERROR_MESSAGE);
			}
		}
		
	}

	public static String getChampLogin() {
		return CHAMP_LOGIN;
	}

	public static String getChampPassword() {
		return CHAMP_PASSWORD;
	}

	public static String getErrorMessage() {
		return ERROR_MESSAGE;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public boolean isStatus() {
		return status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}
	
	


}
