package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Reservation;
import entities.ReservationPK;
import entities.Trajet;
import entities.Utilisateur;

/**
 * Session Bean implementation class ReservationFacade
 */
@Stateless
@LocalBean
public class ReservationFacade {
	
	@PersistenceContext(unitName="monUniteCovoiturage")
	EntityManager em;
	
	
	public boolean ajouterReservation(int idTrajet, String loginClient, int nbrPlace){
		Utilisateur u=em.find(Utilisateur.class, loginClient);
		Trajet tj=em.find(Trajet.class, idTrajet);
		
		if(u !=null) {
			return false;
		}else {
			ReservationPK resPk=new ReservationPK(u,tj);
			Reservation res= new Reservation(resPk,nbrPlace,false);
			em.persist(res);
			return true;
		}
         
		
	}

	
	public boolean ajoutReservation(Reservation r){
		
			em.persist(r);
			return true ; 
 
		
	}
	
	
   

}
