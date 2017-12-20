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
	
	public boolean annulerReservation(ReservationPK resPk,Trajet tj){
		
		Reservation res=em.find(Reservation.class, resPk);
		if(res.isConfirme()) {
			
			int nbrPlaces=res.getNbrPlaceReserve()+tj.getNbrPlaces();
			tj.setNbrPlaces(nbrPlaces);
			em.merge(tj);
			
		}
		em.remove(res);
		return true;
		
	}
	
	public boolean validerReservation(ReservationPK resPk,Trajet tj){
		
		Reservation res=em.find(Reservation.class, resPk);
		if(tj.getNbrPlaces() >= res.getNbrPlaceReserve() ) {
			res.setConfirme(true);
			int nbrPlace=tj.getNbrPlaces()-res.getNbrPlaceReserve();
			tj.setNbrPlaces(nbrPlace);
			em.merge(tj);
			em.merge(res);
			return true;
		}
		return false;
		
	}
	
	public boolean ignorerReservation(ReservationPK resPk,Trajet tj){
		Reservation res=em.find(Reservation.class, resPk);
        if(res.isConfirme()) {
			
			int nbrPlaces=res.getNbrPlaceReserve()+tj.getNbrPlaces();
			tj.setNbrPlaces(nbrPlaces);
			em.merge(tj);
			
		}
		
		res.setConfirme(false);
		em.merge(res);
		return true;
		
	}
	
	
	
   

}
