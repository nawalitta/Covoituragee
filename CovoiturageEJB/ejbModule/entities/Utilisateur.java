package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")

public class Utilisateur {
	@Id  
	private String login;
	private String password;
	@OneToOne(mappedBy="proprietaire")
	private Voiture voiture;
	private String mail;
	private String nomComplet;
	private String numeroTel;
	
	
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id.user")
	private List<Reservation> listReservation;
	public List<Reservation> getListReservation() {
		return listReservation;
	}
	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}
	private Boolean hasVoiture;
	public boolean isHasVoiture() {
		return hasVoiture;
	}
	public void setHasVoiture(boolean hasVoiture) {
		this.hasVoiture = hasVoiture;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
