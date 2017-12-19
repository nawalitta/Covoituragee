package Servlets;

import java.io.IOException;

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
		Utilisateur u = facade.findUtilisateur( currentLogin ) ;
		if(currentLogin==null) {
			
			request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
			return ; 
			}
		
		if((todo!=null) && (todo.equals("reserverTrajet"))) {
			int trajet_id = Integer.parseInt(request.getParameter("trajet_id"));
			Trajet tj= trajetfcd.getTrajet(trajet_id);
			
			
			request.getSession().setAttribute("trajet_id",trajet_id);
			
			request.setAttribute("trajet", tj);
			
			request.getRequestDispatcher("/WEB-INF/confirmerReservation.jsp").forward(request, response);
			return;
		}
		if((todo!=null) && (todo.equals("reserver"))) {
			
			int trajet_id = (int)request.getSession().getAttribute("trajet_id") ;
			int nbrPlace=Integer.parseInt(request.getParameter("nbrplc"));
			Trajet tj= trajetfcd.getTrajet(trajet_id);

			
			ReservationPK resPk=new ReservationPK(u,tj);
			Reservation res= new Reservation(resPk,nbrPlace,false);
			
			
			boolean a = reservationfcd.ajoutReservation(res);
			 System.out.println(a);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			return;
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
