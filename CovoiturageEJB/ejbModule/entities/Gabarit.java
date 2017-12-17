package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gabarit {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idGabarit;
	private String libelleGabarit;
	public int getIdGabarit() {
		return idGabarit;
	}
	public void setIdGabarit(int idGabarit) {
		this.idGabarit = idGabarit;
	}
	public String getLibelleGabarit() {
		return libelleGabarit;
	}
	public void setLibelleGabarit(String libelleGabarit) {
		this.libelleGabarit = libelleGabarit;
	}
	
	
  

}
