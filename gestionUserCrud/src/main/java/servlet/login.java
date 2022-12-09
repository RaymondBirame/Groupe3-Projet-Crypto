package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forms.AuthForm;
import user.User;

/**
 * Servlet implementation class login
 */
@WebServlet({"/login","/logout"})
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		switch (request.getServletPath()){
			case "/logout":
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect("login");
				break;
			case "/login":
				// TODO Auto-generated method stub
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp");
				dispatcher.forward(request, response);
				break;
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthForm form = new AuthForm(request);
		
		if (form.auth()) {
			HttpSession session = request.getSession();
			session.setAttribute("user", session);
			session.setAttribute("isConnected", true);
			response.sendRedirect("list");
		}
		else {
			request.setAttribute("ConnexionFailed", true);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp");
			dispatcher.forward(request, response);
		}
	}

}
