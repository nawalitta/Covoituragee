package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.Facade;
import ejbs.ReservationFacade;
import ejbs.TrajetFacade;
import entities.Reservation;
import entities.ReservationPK;
import entities.Trajet;
import entities.Utilisateur;

@WebServlet("/ReservationController")
public class ReservationController extends HttpServlet {

	@EJB
	TrajetFacade trajetfcd;
	@EJB
	ReservationFacade reservationfcd;
	@EJB
	Facade facade ; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String todo=request.getParameter("todo");
		String currentLogin= (String) request.getSession().getAttribute("login");
		Utilisateur u;
		if(currentLogin==null) {
			
			request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
			return ; 
			
		}
		if((todo!=null) && (todo.equals("listerMesNotifications"))) {
			
			List<Trajet> trajets=trajetfcd.TrajetsDeUser(currentLogin);
			System.out.println(trajets.size()+ "hh");
			List<Reservation> notifications=new ArrayList();
			ArrayList<Reservation> notifTrajet=null;
			for (Trajet trajet : trajets){
				notifTrajet=trajetfcd.getListReservationTrajet(trajet.getIdTrajet());
				if(notifTrajet.size() > 0) {
					for(Reservation res : notifTrajet) {
						notifications.add(res);
					}
				}
			}
			request.setAttribute("listNotifications", notifications);
			request.getRequestDispatcher("/WEB-INF/mesNotifications.jsp").forward(request, response);
			return;
			  
		}
		if((todo!=null) && (todo.equals("ValiderReservation"))) {
			int trajet_id = Integer.parseInt(request.getParameter("trajet_id"));
			String loginClient = request.getParameter("id");
			u = facade.findUtilisateur( loginClient) ;
			Trajet tj= trajetfcd.getTrajet(trajet_id);
			ReservationPK resPk=new ReservationPK(u,tj);
			if(reservationfcd.validerReservation(resPk,tj)) {
				request.getRequestDispatcher("/reservation?todo=listerMesNotifications").forward(request, response);
				return;
			}else {
				request.getRequestDispatcher("/reservation?todo=listerMesNotifications").forward(request, response);
				return;
				
			}
			
			
		}
		
		if((todo!=null) && (todo.equals("IgnorerReservation"))) {
			int trajet_id = Integer.parseInt(request.getParameter("trajet_id"));
			String loginClient = request.getParameter("id");
			u = facade.findUtilisateur( loginClient) ;
			Trajet tj= trajetfcd.getTrajet(trajet_id);
			ReservationPK resPk=new ReservationPK(u,tj);
			boolean conf = reservationfcd.ignorerReservation(resPk,tj);
			request.getRequestDispatcher("/reservation?todo=listerMesNotifications").forward(request, response);
			return;
			
		}
		
		
		if((todo!=null) && (todo.equals("reserverTrajet"))) {
			
			int trajet_id = Integer.parseInt(request.getParameter("trajet_id"));
			Trajet tj= trajetfcd.getTrajet(trajet_id);
			request.getSession().setAttribute("trajet_id",trajet_id);
			request.setAttribute("trajet", tj);
			request.getRequestDispatcher("/WEB-INF/confirmerReservation.jsp").forward(request, response);
			return;
			
		}
		if((todo!=null) && (todo.equals("listerMesReservations"))) {
			
			u = facade.findUtilisateur( currentLogin ) ;
			request.setAttribute("listReservation", u.getListReservation());
			request.getRequestDispatcher("/WEB-INF/mesReservations.jsp").forward(request, response);
			return;
			
		}
		if((todo!=null) && (todo.equals("AnnulerReservation"))) {
			
			int trajet_id=Integer.parseInt(request.getParameter("trj"));
			u = facade.findUtilisateur( currentLogin ) ;
			Trajet tj= trajetfcd.getTrajet(trajet_id);
			ReservationPK resPk=new ReservationPK(u,tj);
			boolean conf = reservationfcd.annulerReservation(resPk,tj);
			request.getRequestDispatcher("/reservation?todo=listerMesReservations").forward(request, response);
			return;
			
		}
		if((todo!=null) && (todo.equals("reserver"))) {
			
			int trajet_id = (int)request.getSession().getAttribute("trajet_id") ;
			int nbrPlace=Integer.parseInt(request.getParameter("nbrplc"));
			Trajet tj= trajetfcd.getTrajet(trajet_id);
			if(tj.getNbrPlaces()>=nbrPlace) {
				
					u = facade.findUtilisateur(currentLogin) ;
					ReservationPK resPk=new ReservationPK(u,tj);
					Reservation res= new Reservation(resPk,nbrPlace,false);
					
					reservationfcd.ajoutReservation(res);
					request.getRequestDispatcher("/reservation?todo=listerMesReservations").forward(request, response);
					return;
					
			}else {
				request.getRequestDispatcher("/trajet?todo=clickRecherche").forward(request, response);
				return;
				
			}
			
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
