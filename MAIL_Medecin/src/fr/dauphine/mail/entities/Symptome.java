package fr.dauphine.mail.entities;

import java.io.Serializable;

public class Symptome implements Serializable {

	private Long idSymptome;
	private String libelle;
	private Traitement traitement;
	
	public Symptome() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Symptome(Long idSymptome, String libelle, Traitement traitement) {
		this.idSymptome = idSymptome;
		this.libelle = libelle;
		this.traitement = traitement;
	}


	public Long getIdSymptome() {
		return idSymptome;
	}

	public void setIdSymptome(Long idSymptome) {
		this.idSymptome = idSymptome;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Traitement getTraitement() {
		return traitement;
	}

	public void setTraitement(Traitement traitement) {
		this.traitement = traitement;
	}
	

}
