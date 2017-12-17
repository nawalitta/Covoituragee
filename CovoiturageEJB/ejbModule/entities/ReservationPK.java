package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable

public class ReservationPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Utilisateur user;
	
	@ManyToOne
	private Trajet trajet;

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

}
