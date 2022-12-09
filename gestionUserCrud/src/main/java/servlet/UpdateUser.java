package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import dao.Userdao;
/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("id");
		
		if(sid!= null && sid.matches("[0-9]+")) {
			int id = Integer.parseInt(sid);
			User utilisateur = dao.Userdao.getUserById(id);
			if(utilisateur!=null) {
				 request.setAttribute("utilisateur", utilisateur);
				 getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(request,response);
				return;
			}
		}
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String sid = request.getParameter("id");
	   int id = Integer.parseInt(sid);
	   String nom=request.getParameter("nom");
	   String prenom=request.getParameter("prenom");
	   String login=request.getParameter("login");
	   String password=request.getParameter("password");
	   
	   User user = new User();
	   user.setId(id);
	   user.setNom(nom);
	   user.setPrenom(prenom);
	   user.setLogin(login);
	   user.setPassword(password);
	   
	   Userdao.updateUser(user);
	   response.sendRedirect("list");
	}

}
