package fr.dauphine.mail.entities;

import java.io.Serializable;
import java.util.List;

public class Maladie implements Serializable {

	private Long idMaladie;
	private String libelle;
	private String description;
	private List<Medicament> medicaments;
	
	public Maladie() {
	}
	
	

	public Maladie(Long idMaladie, String libelle, String description,
			List<Medicament> medicaments) {
		this.idMaladie = idMaladie;
		this.libelle = libelle;
		this.description = description;
		this.medicaments = medicaments;
	}



	public Long getIdMaladie() {
		return idMaladie;
	}

	public void setIdMaladie(Long idMaladie) {
		this.idMaladie = idMaladie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}
	

}
