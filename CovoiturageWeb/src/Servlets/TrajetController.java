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
import ejbs.TrajetFacade;
import entities.Trajet;
import entities.Utilisateur;
import entities.Ville;

/**
 * Servlet implementation class TrajetController
 */
@WebServlet("/TrajetController")
public class TrajetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	Facade facade ; 
	
	@EJB
	TrajetFacade trajetfcd;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todo=request.getParameter("todo");
		String currentLogin= (String) request.getSession().getAttribute("login");
		Utilisateur u;
		
		List<Ville> villes = trajetfcd.getAllVille() ;
		request.setAttribute("listville", villes);
        if((todo!=null) && (todo.equals("recherchetrajet"))) {
			
			String Ville_depart = request.getParameter("vdepart"); 
			String Ville_arrive = request.getParameter("varrive");
			List<Trajet> trajets=trajetfcd.rechercherTrajet(Integer.parseInt(Ville_depart) , Integer.parseInt(Ville_arrive)) ; 
			request.setAttribute("listTrajets", trajets);
			request.getRequestDispatcher("/WEB-INF/resultatRechercheTrajet.jsp").forward(request, response);
			return ;
			
			
		}
        if((todo!=null) && (todo.equals("clickRecherche"))) {
			request.getRequestDispatcher("/WEB-INF/RechercherTrajet.jsp").forward(request, response);
			return ;	
		}
		
		if(currentLogin==null) {
		
			request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
			return ; 
			}
		
		if((todo!=null) && (todo.equals("clickModifiertrajet"))) {
			
					int trajet_id = (int) request.getSession().getAttribute("trajet_id");
					Trajet trajeta = trajetfcd.getTrajet(trajet_id) ; 
			
					String vdepart = request.getParameter("vdepart");
					String varrive = request.getParameter("varrive");
					String heure_depart = request.getParameter("hdepart"); 
					String date_depart = request.getParameter("ddepart");
					String nbr_place = request.getParameter("nbrp");
					
					System.out.println(vdepart);
					 Ville villed = trajetfcd.getVille(Integer.parseInt(vdepart)) ; 
					 Ville villea = trajetfcd.getVille(Integer.parseInt(varrive)) ; 
					 u = facade.findUtilisateur( currentLogin ) ;
					 Trajet trajet = new Trajet(heure_depart, date_depart, villed, villea,Integer.parseInt( nbr_place),u);
					 trajetfcd.modifierTrajet(trajet); 
			
					request.getRequestDispatcher("/trajet?todo=listerTrajets").forward(request, response);
	     }
		
		if((todo!=null) && (todo.equals("modifierTrajet"))){
					List<Trajet> trajets = trajetfcd.TrajetsDeUser(currentLogin);
					int trajet_id = Integer.parseInt(request.getParameter("trajet_id"));
					request.getSession().setAttribute("trajet_id",trajet_id );
					Trajet trajet = trajetfcd.getTrajet(trajet_id) ; 
					request.setAttribute("vdepart", trajet.getVilleDepart());
					request.setAttribute("varrive", trajet.getVilleArrive()) ; 
					request.setAttribute("hdepart", trajet.getHeureDepart());
					request.setAttribute("ddepart", trajet.getDatedepart()) ; 
					request.setAttribute("nbrplc", trajet.getNbrPlaces()) ; 
					request.getRequestDispatcher("/WEB-INF/ModifierTrajet.jsp").forward(request, response);
					return ;
		}
		
			
		if((todo!=null) && (todo.equals("delTrajet"))) {
					int trajet_id = Integer.parseInt(request.getParameter("trajet_id"));
					
					
					Trajet trajet = trajetfcd.getTrajet(trajet_id);
					if (trajet != null) {
						
						trajetfcd.deleteTrajet(trajet_id);
							}
					
				
					request.getRequestDispatcher("/trajet?todo=listerTrajets").forward(request, response);
					return ; 
		}
				
		if((todo!=null) && (todo.equals("listerTrajets"))) {
			List<Trajet> trajets = trajetfcd.TrajetsDeUser(currentLogin) ;
			request.setAttribute("listTrajets", trajets);
			request.getRequestDispatcher("/WEB-INF/mesTrajets.jsp").forward(request, response);
			return ; 
		}
		if((todo!=null) && (todo.equals("ajoutrajet"))) {
		
					String vdepart = request.getParameter("vdepart");
					String varrive = request.getParameter("varrive");
					String heure_depart = request.getParameter("hdepart"); 
					String date_depart = request.getParameter("ddepart");
					System.out.println(heure_depart);
					System.out.println(date_depart);
					String nbr_place = request.getParameter("nbrp");
					 Ville villed = trajetfcd.getVille(Integer.parseInt(vdepart)) ; 
					 Ville villea = trajetfcd.getVille(Integer.parseInt(varrive)) ; 
					 u = facade.findUtilisateur( currentLogin ) ;
					Trajet trajet = new Trajet(heure_depart, date_depart, villed, villea,Integer.parseInt( nbr_place),u);
					trajetfcd.add(trajet);
					request.getRequestDispatcher("/trajet?&todo=listerTrajets").forward(request, response);
					return ; 
		}
		
		u = facade.findUtilisateur( currentLogin ) ;
		if(!u.isHasVoiture()) {
			 request.getSession().setAttribute("ajout","false");
		     request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
		     return;
		     
		}
		
	     request.getRequestDispatcher("/WEB-INF/AjouterTrajet.jsp").forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
