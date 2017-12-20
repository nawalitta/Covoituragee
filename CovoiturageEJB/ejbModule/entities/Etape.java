package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Etape")
public class Etape {
	
	
	@Id   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEtape;
	
	@OneToOne
	private Ville ville ;
	
	

	public Etape() {
		
	}

	public int getIdEtape() {
		return idEtape;
	}

	public void setIdEtape(int idEtape) {
		this.idEtape = idEtape;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	@ManyToOne
	@JoinColumn(name= "trajet_id")
	private Trajet trajet ; 
	
	private int prix  ;
	
	public Etape(Ville ville, Trajet trajet, int prix) {
		this.ville = ville;
		this.trajet = trajet;
		this.prix = prix;
	}
}
