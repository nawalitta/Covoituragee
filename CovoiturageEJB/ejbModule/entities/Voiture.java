package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Voiture {
	@Id 
	private int idVoiture;
	private String type;
	private String modele;
	public int getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}

	

}
