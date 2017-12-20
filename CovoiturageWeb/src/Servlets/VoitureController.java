package Servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.Facade;
import entities.Gabarit;


/**
 * Servlet implementation class VoitureController
 */
@WebServlet("/VoitureController")
public class VoitureController extends HttpServlet {
	@EJB
	private Facade facade;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String voiture=request.getParameter("voiture");
	     String login = (String) request.getSession().getAttribute("login");
	     
	     if(login==null) {
	    	 
	    	 	this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	    	 	return;
	     }
	     if((voiture!=null) && (voiture.equals("ajouterVoiture"))) {
	    	 
			 String modele = request.getParameter("modele");
			 String success = request.getParameter("success");

			 int idGabarit= Integer.parseInt(request.getParameter("gabarit"));
			 request.setAttribute("ajoutVoi", facade.ajouterVoiture(login,modele,idGabarit));
			 request.getSession().setAttribute("ajout","true");
			 request.setAttribute("success",success );

			 this.getServletContext().getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
			 
			 return;
			 
	     }
	     if((voiture!=null) && (voiture.equals("supprimer"))) {
	    	 
			 request.setAttribute("supprimer", facade.supprimerVoiture(login));
			 request.getSession().setAttribute("ajout","false");
			 this.getServletContext().getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
			 return;
			 
		  }
	     if((voiture!=null) && (voiture.equals("modifier"))) {
	    	 
	    	   request.setAttribute("modele", facade.getVoiture(login).getModele());
	    	   request.setAttribute("nonlistGabarit", facade.getNonListGabarit(login));
	    	   request.setAttribute("idGabaritSelectionne",  facade.getVoiture(login).getGabarit().getIdGabarit());
	    	   request.setAttribute("libelleGabaritSelectionne",  facade.getVoiture(login).getGabarit().getLibelleGabarit());
	 	    this.getServletContext().getRequestDispatcher("/WEB-INF/modifierVoiture.jsp").forward(request, response);
	 	    return;
	 	    
		  }
	     if((voiture!=null) && (voiture.equals("modifierVoiture"))) {
	    	 
	    	     String modele = request.getParameter("modele");
	    	     int idGabarit= Integer.parseInt(request.getParameter("gabarit"));
			 request.setAttribute("modele", facade.modifierVoiture(login,modele,idGabarit));
			 request.getSession().setAttribute("ajout","true");
			 this.getServletContext().getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
			 return;
			 
		 }
	    request.setAttribute("listGabarit", facade.getAllGabarit()); 
	    request.getSession().setAttribute("ajout","false");
	    this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterVoiture.jsp").forward(request, response);
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
    	 

	}

}
