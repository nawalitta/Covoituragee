package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Utilisateur;



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
	
	

}
