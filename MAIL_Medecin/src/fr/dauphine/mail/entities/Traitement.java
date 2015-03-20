package fr.dauphine.mail.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Traitement implements Serializable {
	
	private Long idTraitement;
	private int dureeJours;
	private Date dateDebut;
	private int progres;
	
	private Medecin medecin;
	private Patient patient;
	private Maladie maladie;
	private List<Medicament> medicaments;
	private List<Symptome> symptomes;
	
	
	public Traitement() {
	}

	
	public Traitement(Long idTraitement, int dureeJours, Date dateDebut,
			int progres, Medecin medecin, Patient patient, Maladie maladie,
			List<Medicament> medicaments, List<Symptome> symptomes) {
		this.idTraitement = idTraitement;
		this.dureeJours = dureeJours;
		this.dateDebut = dateDebut;
		this.progres = progres;
		this.medecin = medecin;
		this.patient = patient;
		this.maladie = maladie;
		this.medicaments = medicaments;
		this.symptomes = symptomes;
	}


	public Long getIdTraitement() {
		return idTraitement;
	}


	public void setIdTraitement(Long idTraitement) {
		this.idTraitement = idTraitement;
	}


	public int getDureeJours() {
		return dureeJours;
	}


	public void setDureeJours(int dureeJours) {
		this.dureeJours = dureeJours;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public int getProgres() {
		return progres;
	}


	public void setProgres(int progres) {
		this.progres = progres;
	}


	public Medecin getMedecin() {
		return medecin;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Maladie getMaladie() {
		return maladie;
	}


	public void setMaladie(Maladie maladie) {
		this.maladie = maladie;
	}


	public List<Medicament> getMedicaments() {
		return medicaments;
	}


	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}


	public List<Symptome> getSymptomes() {
		return symptomes;
	}


	public void setSymptomes(List<Symptome> symptomes) {
		this.symptomes = symptomes;
	}
		
	
}
