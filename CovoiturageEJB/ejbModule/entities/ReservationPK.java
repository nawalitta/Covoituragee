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
	
	public ReservationPK() {
		
	}

	public Utilisateur getUser() {
		return user;
	}

	public ReservationPK(Utilisateur user, Trajet trajet) {
		this.user = user;
		this.trajet = trajet;
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
