package fr.dauphine.mail.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Medecin implements Serializable {
	
	
	private Long idMedecin;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String tel;
	private String email;
	private String specialite;
	private String adresse;
	private String ville;
	private List<Traitement> traitements;
	
	public Medecin() {
	}

	
	public Medecin(Long idMedecin, String nom, String prenom,
			Date dateNaissance, String tel, String email, String specialite,
			String adresse, String ville, List<Traitement> traitements) {
		this.idMedecin = idMedecin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.tel = tel;
		this.email = email;
		this.specialite = specialite;
		this.adresse = adresse;
		this.ville = ville;
		this.traitements = traitements;
	}


	public Long getIdMedecin() {
		return idMedecin;
	}


	public void setIdMedecin(Long idMedecin) {
		this.idMedecin = idMedecin;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getSpecialite() {
		return specialite;
	}


	public void setSpecialite(String specialite) {
		this.specialite = specialite;
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


	public List<Traitement> getTraitements() {
		return traitements;
	}


	public void setTraitements(List<Traitement> traitements) {
		this.traitements = traitements;
	}
	
	
	
	
	
	
	
}
