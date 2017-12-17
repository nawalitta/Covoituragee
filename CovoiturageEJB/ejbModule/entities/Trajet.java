package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Trajet")
public class Trajet {
	
	@Id  
	private int idTrajet;
	private String heureDepart;
	private String datedepart;
	private int nbrPlaces;

	@ManyToOne
	@JoinColumn(name= "utilisateur_id")
	private Utilisateur utilisateur;
	
	@OneToOne
	private Ville villeDepart;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.trajet", cascade = CascadeType.ALL)
	private List<Reservation> listReservation;
	
	public Trajet() {
		
	}
	
	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	public Trajet(String heureDepart, String datedepart, Ville villeDepart, Ville villeArrive, int nbrPlaces,Utilisateur utilisateur) {
		this.heureDepart = heureDepart;
		this.datedepart = datedepart;
		this.villeDepart = villeDepart;
		this.villeArrive = villeArrive;
		this.nbrPlaces = nbrPlaces;
		this.utilisateur =utilisateur ;
	}
	@OneToOne 
	private Ville villeArrive;
	public int getIdTrajet() {
		return idTrajet;
	}
	public void setIdTrajet(int idTrajet) {
		this.idTrajet = idTrajet;
	}
	public String getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	public String getDatedepart() {
		return datedepart;
	}
	public void setDatedepart(String datedepart) {
		this.datedepart = datedepart;
	}
	public Ville getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(Ville villeDepart) {
		this.villeDepart = villeDepart;
	}
	public Ville getVilleArrive() {
		return villeArrive;
	}
	public void setVilleArrive(Ville villeArrive) {
		this.villeArrive = villeArrive;
	}
	public int getNbrPlaces() {
		return nbrPlaces;
	}
	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}
	
	

}
