package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Etape;
import entities.Trajet;

/**
 * Session Bean implementation class EtapeFacade
 */
@Stateless
@LocalBean
public class EtapeFacade {

    
	@PersistenceContext(unitName="monUniteCovoiturage")
	EntityManager em;
	
	
	public void add(Etape etape) {
		em.persist(etape);
	}
	
	
}
