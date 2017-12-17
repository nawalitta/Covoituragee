package entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity 
@Table(name="Reservation")
@AssociationOverrides({

  @AssociationOverride(name = "id.user", joinColumns = @JoinColumn(name = "user_id")),

  @AssociationOverride(name = "id.trajet", joinColumns = @JoinColumn(name = "trajet_id")) })

public class Reservation {
	
	@EmbeddedId
	 private ReservationPK id = new ReservationPK();

	private int nbrPlaceReserve;
	private boolean confirme;
	public int getNbrPlaceReserve() {
		return nbrPlaceReserve;
	}
	public void setNbrPlaceReserve(int nbrPlaceReserve) {
		this.nbrPlaceReserve = nbrPlaceReserve;
	}
	public boolean isConfirme() {
		return confirme;
	}
	public void setConfirme(boolean confirme) {
		this.confirme = confirme;
	}

}
