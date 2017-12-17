package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Voiture {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVoiture;
	private String modele;
	@OneToOne
	@JoinColumn(name="proprietaire_voiture") 
	private Utilisateur proprietaire;
	@OneToOne
	@JoinColumn(name="gabarit_id") 
	private Gabarit gabarit;
	public int getIdVoiture() {
		return idVoiture;
	}
	public Utilisateur getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}
	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}
	public Gabarit getGabarit() {
		return gabarit;
	}
	public void setGabarit(Gabarit gabarit) {
		this.gabarit = gabarit;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}

	

}
