package fr.dauphine.mail.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class MedicamentProperty implements Serializable {
	
	private Long idMP;
	private String libelle;
	private MedicPropertyType type; 
	
	public enum MedicPropertyType{
		INDICATION, CONTRE_INDICATION, SUBSTANCE_ACTIVE, DOSE
	}
	
	
	public MedicamentProperty() {
	}
	
	

	public MedicamentProperty(Long idMP, String libelle, MedicPropertyType type) {
		this.idMP = idMP;
		this.libelle = libelle;
		this.type = type;
	}


	public Long getIdMP() {
		return idMP;
	}



	public void setIdMP(Long idMP) {
		this.idMP = idMP;
	}



	public MedicPropertyType getType() {
		return type;
	}



	public void setType(MedicPropertyType type) {
		this.type = type;
	}



	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

}
