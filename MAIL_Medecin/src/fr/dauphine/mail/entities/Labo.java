package fr.dauphine.mail.entities;

import java.io.Serializable;

public class Labo implements Serializable {
	

	private Long idLabo;
	private String nom;
	private String adresse;
	private String ville;
	
	
	public Labo() {
	}
	
	
	


	public Labo(Long idLabo, String nom, String adresse, String ville) {
		this.idLabo = idLabo;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
	}





	public Long getIdLabo() {
		return idLabo;
	}




	public void setIdLabo(Long idLabo) {
		this.idLabo = idLabo;
	}




	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}

	
	
	

}
