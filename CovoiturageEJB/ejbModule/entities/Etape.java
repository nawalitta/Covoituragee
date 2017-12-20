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
