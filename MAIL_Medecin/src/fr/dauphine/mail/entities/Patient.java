package fr.dauphine.mail.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Patient implements Serializable{
	
	private Long idPatient;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String sexe;
	private String tel;
	private String adresse;
	private String ville;
	private List<Traitement> traitements;
	
	public Patient() {
	}
	
	
	public Patient(Long idPatient, String nom, String prenom,
			Date dateNaissance, String sexe, String tel, String adresse,
			String ville, List<Traitement> traitements) {
		this.idPatient = idPatient;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.tel = tel;
		this.adresse = adresse;
		this.ville = ville;
		this.traitements = traitements;
	}


	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
