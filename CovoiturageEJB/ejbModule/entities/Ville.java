package entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Ville {
    @Id
	private int idVille; 
	private String LabelVille ;
	public int getIdVille() {
		return idVille;
	}
	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}
	public String getLabelVille() {
		return LabelVille;
	}
	public void setLabelVille(String labelVille) {
		LabelVille = labelVille;
	} 
}
