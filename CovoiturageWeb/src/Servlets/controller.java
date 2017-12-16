package Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.Facade;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Facade facade;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todo=request.getParameter("todo");
		
		String currentLogin=(String) request.getSession().getAttribute("login");
		
		System.out.println("coucou");
		if(todo.equals("inscript")) {
			request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
			
		}
		
		if(currentLogin==null) {
			if((todo!=null) && (todo.equals("connect"))) {
				String login=request.getParameter("login");
				String password=request.getParameter("password");
				System.out.println(facade.utilisateurValide(login,password));
				if(facade.utilisateurValide(login,password)) {
				request.getSession().setAttribute("login", login);
				return;
				}
			}
				request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
				
			
			return;
		}
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
