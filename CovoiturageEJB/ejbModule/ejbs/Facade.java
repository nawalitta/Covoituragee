package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import entities.Trajet;

import javax.persistence.Query;

import entities.Gabarit;
import entities.Utilisateur;
import entities.Voiture;



/**
 * Session Bean implementation class Facade
 */
@Stateless
@LocalBean
public class Facade {

	@PersistenceContext(unitName="monUniteCovoiturage")
	EntityManager em;
	
	public Utilisateur findUtilisateur(String login) {
		return  em.find(Utilisateur.class,login);
		
	}
	 
	public boolean utilisateurValide(String login,String password) {
		Utilisateur u=em.find(Utilisateur.class, login);
		if(u==null) {
			return false;
		}else {
			if(u.getPassword().equals(password)) {
				return true;
			}
			return false;
		}
		
	}
	public boolean ajouterUtilisateur(String login,String password,String mail, String nom, String num){
		Utilisateur u=em.find(Utilisateur.class, login);
		if(u !=null) {
			return false;
		}else {
			Utilisateur user=new Utilisateur();
			user.setLogin(login);
			user.setPassword(password);
			user.setMail(mail);
			user.setNomComplet(nom);
			user.setNumeroTel(num);
			user.setHasVoiture(false);
			em.persist(user);
			return true;
		}
         
		
	}
	
	public Voiture getVoiture(String login){
		Utilisateur u=em.find(Utilisateur.class, login);
		Query q=em.createQuery("From Voiture v where v.proprietaire=?");
		q.setParameter(1, u);
		return (Voiture)q.getSingleResult();
	}
	public boolean ajouterVoiture(String login,String modele,int idGabarit) {
		Utilisateur u=em.find(Utilisateur.class, login);
		Gabarit g=em.find(Gabarit.class, idGabarit);
		if(u==null || g==null) {
			return false;
		}else {
			Voiture voiture=new Voiture();
			voiture.setModele(modele);
			voiture.setProprietaire(u);
			voiture.setGabarit(g);
			em.persist(voiture);
			u.setHasVoiture(true);
			em.merge(u);
			return true;
		}
		
		
	}
	public boolean supprimerVoiture(String login) {
		Utilisateur u=em.find(Utilisateur.class, login);
		Query q=em.createQuery("From Voiture v where v.proprietaire=?");
		q.setParameter(1, u);
		Voiture voiture=(Voiture)q.getSingleResult();
		if((u==null) || (voiture ==null)) {
			return false;
		}else {
			em.remove(voiture);
			u.setHasVoiture(false);
			em.merge(u);
			return true;
		}
		
	}
	public boolean modifierVoiture(String login,String modele,int idGabarit) {
		Utilisateur u=em.find(Utilisateur.class, login);
		Gabarit g=em.find(Gabarit.class, idGabarit);
		Query q=em.createQuery("From Voiture v where v.proprietaire=?");
		q.setParameter(1, u);
		Voiture voiture=(Voiture)q.getSingleResult();
		if((u==null) || (voiture ==null) || (g==null)) {
			return false;
		}else {
			voiture.setModele(modele);
			voiture.setGabarit(g);
			em.persist(voiture);
			return true;
		}
		
	}
	public List<Gabarit> getAllGabarit(){
		return  em.createQuery("From Gabarit g").getResultList();

	}
	public List<Gabarit> getNonListGabarit(String login){
		Gabarit gabarit=getVoiture(login).getGabarit();
		List<Gabarit> l=getAllGabarit();
		l.remove(gabarit);
		return l;
    }
	
	
	
	
	

}
