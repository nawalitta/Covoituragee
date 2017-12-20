package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "Trajet")
public class Trajet {
	

	@Id   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTrajet;
	
	@OrderBy(" heureDepart ASC")
	private String heureDepart;
	private int prix;

	private String datedepart;
	private int nbrPlaces;

	private int nbrEtapes;
	
	//@OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	@OneToMany(mappedBy= "trajet")
	private List<Etape> lesEtapes ;
	
	public int getNbrEtapes() {
		return nbrEtapes;
	}

	public void setNbrEtapes(int nbrEtapes) {
		this.nbrEtapes = nbrEtapes;
	}

	/*public List<Etape> getLesEtapes() {
		return lesEtapes;
	}

	public void setLesEtapes(List<Etape> lesEtapes) {
		this.lesEtapes = lesEtapes;
	}*/
	@ManyToOne
	@JoinColumn(name= "utilisateur_id")
	private Utilisateur utilisateur;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	@OneToOne
	private Ville villeDepart;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id.trajet")
	private List<Reservation> listReservation;
	
	public Trajet() {
		
	}
	
	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	public Trajet(String heureDepart, String datedepart,int prix, Ville villeDepart,  Ville villeArrive,int nbrEtapes , int nbrPlaces,Utilisateur utilisateur) {
		this.heureDepart = heureDepart;
		this.datedepart = datedepart;
		this.villeDepart = villeDepart;
		this.villeArrive = villeArrive;
		this.nbrPlaces = nbrPlaces;
		this.nbrEtapes = nbrEtapes;
		this.prix=prix ;
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
