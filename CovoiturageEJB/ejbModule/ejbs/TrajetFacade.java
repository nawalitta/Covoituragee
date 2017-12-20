package ejbs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Reservation;
import entities.Trajet;
import entities.Utilisateur;
import entities.Ville;

/**
 * Session Bean implementation class TrajetFacade
 */
@Stateless
@LocalBean
public class TrajetFacade {

	@PersistenceContext(unitName="monUniteCovoiturage")
	EntityManager em;
	
	
	
	public void add(Trajet trajet) {
		em.persist(trajet);
	}
	
	
	public List<Ville> getAllVille() {
		return em.createQuery("From Ville v ").getResultList() ;

	}

	public Ville getVille(int id) {
		Ville ville = em.find(Ville.class, id);
		
		return ville;
	}

	public List<Trajet> TrajetsDeUser(String login) {
		
		Utilisateur u =  em.find(Utilisateur.class,login);
		 
		Query q = em.createQuery("From Trajet t where t.utilisateur=? ");
		  q.setParameter(1, u) ; 
		  return q.getResultList() ;

	}
	
	public Trajet getTrajet(int id) {
		Trajet trajet = em.find(Trajet.class, id);
		
		return trajet;
	}
	
	
	public void deleteTrajet(int id) {
		Trajet trajet = getTrajet(id);
		em.remove(trajet);
	}

	public void modifierTrajet(Trajet t) {
		em.merge(t);
	}
	
	
	public List<Trajet> rechercherTrajet(int a , int b) {
	
		Query q = em.createQuery("From Trajet t where t.villeDepart=? and t.villeArrive=? ");
		
		 q.setParameter(1, getVille(a)) ;
		 q.setParameter(2, getVille(b)) ;
		 
		 return q.getResultList() ;
		
		
	}
	
	public ArrayList<Reservation> getListReservationTrajet(int trajet_id){
		Query q = em.createQuery("From Reservation t where t.id.trajet.idTrajet=?");
		q.setParameter(1, trajet_id) ;
		return (ArrayList<Reservation>) q.getResultList() ;
		
	}

	
	
	
	
	
	
	
	
	
	

}
