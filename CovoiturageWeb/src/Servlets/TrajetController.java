package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.EtapeFacade;
import ejbs.Facade;
import ejbs.TrajetFacade;
import entities.Etape;
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
	
	@EJB
	EtapeFacade etapefcd;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todo=request.getParameter("todo");
		String currentLogin= (String) request.getSession().getAttribute("login");
		Utilisateur u  ;
		

		List<Ville> villes = trajetfcd.getAllVille() ;
		request.setAttribute("listville", villes);
		
		if((todo!=null) && (todo.equals("clickRecherche"))) {
			request.getRequestDispatcher("/WEB-INF/RechercherTrajet.jsp").forward(request, response);
			return ;	
		}
		
		
		if((todo!=null) && (todo.equals("recherchetrajet"))) {
			
			
			String Ville_depart = request.getParameter("vdepart"); 
			String Ville_arrive = request.getParameter("varrive");
			String Date_depart = request.getParameter("ddepart");

			List<Trajet> trajets=trajetfcd.rechercherTrajet(Integer.parseInt(Ville_depart) , Integer.parseInt(Ville_arrive),Date_depart) ; 
			request.setAttribute("listTrajets", trajets);
			
			request.getRequestDispatcher("/WEB-INF/resultatRechercheTrajet.jsp").forward(request, response);
			return ;
			
			
		}
		if(currentLogin==null) {
		
			request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
			return ; 
			}
		
		/*if((todo!=null) && (todo.equals("clickModifiertrajet"))) {
			
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
					
					Trajet trajet = new Trajet(heure_depart, date_depart, villed, villea,Integer.parseInt( nbr_place),u);
					 trajetfcd.modifierTrajet(trajet); 
			
					request.getRequestDispatcher("/trajet?todo=listerTrajets").forward(request, response);
	     } */
		
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
			String success = (String) request.getAttribute("success") ;
			

			request.setAttribute("success", success);

			
			
			request.setAttribute("listTrajets", trajets);
			System.out.println(trajets.size());

			request.getRequestDispatcher("/WEB-INF/mesTrajets.jsp").forward(request, response);
			return ; 
		}
		
	
		
		if((todo!=null) && (todo.equals("nmbretapes"))) {
			
			//request.setAttribute("nbrEtapes", request.getParameter("nbrEtapes"));
			request.getSession().setAttribute("nbrEtapes", request.getParameter("nbrEtapes"));
			request.getRequestDispatcher("/WEB-INF/AjouterTrajet.jsp").forward(request, response);

		}
		
		
		if((todo!=null) && (todo.equals("ajoutrajet"))) {
	

					String vdepart = request.getParameter("vdepart");
					String varrive = request.getParameter("varrive");
					String heure_depart = request.getParameter("hdepart"); 
					String date_depart = request.getParameter("ddepart");
					int prixt =Integer.parseInt(request.getParameter("prixt")) ;
					String success = request.getParameter("success");

					System.out.println(heure_depart);
					System.out.println(date_depart);
					int nbr_place = Integer.parseInt( request.getParameter("nbrp"));
					int nbr_etapes = Integer.parseInt((String) request.getSession().getAttribute("nbrEtapes"));  
					
					 Ville villed = trajetfcd.getVille(Integer.parseInt(vdepart)) ; 
					 Ville villea = trajetfcd.getVille(Integer.parseInt(varrive)) ; 
					 u= facade.findUtilisateur( currentLogin );
					Trajet trajet = new Trajet(heure_depart, date_depart,prixt, villed, villea,nbr_etapes,nbr_place,u);
					trajetfcd.add(trajet);

					for(int i=1 ; i<=nbr_etapes ;i++) {
						//	Etape(Ville ville, Trajet trajet, int prix)
							
						Etape t =	new Etape (trajetfcd.getVille(Integer.parseInt(request.getParameter("etape"+i))),
									trajet, Integer.parseInt( request.getParameter("prix"+i)) )  ;
							
							
							etapefcd.add( t) ;
						}
					
					request.setAttribute("success", "ok");
					
					
					request.getRequestDispatcher("/trajet?&todo=listerTrajets").forward(request, response);
					
					return ; 
		}
		
		
		
		
		u = facade.findUtilisateur( currentLogin ) ;
		 		if(!u.isHasVoiture()) {
		 			 request.getSession().setAttribute("ajout","false");
		 		     request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
		 		     return;
				     
		 		}


		request.getRequestDispatcher("/WEB-INF/etapes.jsp").forward(request, response);

		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
