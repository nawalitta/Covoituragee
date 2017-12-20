package Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.Facade;
import entities.Utilisateur;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionController")
public class ConnexionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Facade facade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String todo=request.getParameter("todo");
		String currentLogin=(String) request.getSession().getAttribute("login");
		
		if(currentLogin==null) {
			if((todo!=null) && (todo.equals("connect"))) {
				String login=request.getParameter("login");
				String password=request.getParameter("password");
				System.out.println(facade.utilisateurValide(login,password));
				if(facade.utilisateurValide(login,password)) {
				request.getSession().setAttribute("login", login);
				request.getSession().setAttribute("connecter", "ok");
				/* Affichage de la page de connexion */
		        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		        return;
		        }
			}
			if((todo!=null) && (todo.equals("inscript"))) {
		        request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		        return;
			}
			if((todo!=null) && (todo.equals("inscriptUser"))) {
				String login=request.getParameter("login");
				String password=request.getParameter("password");
				String vpassword=request.getParameter("vpassword");
				String mail=request.getParameter("mail");
				String nom=request.getParameter("nom");
				String num=request.getParameter("numTele");

				if(password.equals(vpassword)) {
					if(!facade.ajouterUtilisateur(login,password,mail,nom,num)) {
						request.setAttribute("ajouterUser", "existe login");
						 request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
					     return;
						
					}
				}else {
					request.setAttribute("alert", "alert");
					 request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
				     return;
					
				}
		       
			}

	       request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward( request, response );	
	       return;

		}	
		Utilisateur u = facade.findUtilisateur( currentLogin ) ;
		if(u.isHasVoiture()) {
			request.getSession().setAttribute("ajout","true"); 
		}else {
			request.getSession().setAttribute("ajout","false"); 
		}
		request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
