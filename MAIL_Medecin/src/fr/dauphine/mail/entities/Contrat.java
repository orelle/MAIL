package fr.dauphine.mail.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


public class Contrat implements Serializable {
	
	private Long idContrat;
	private Labo labo;
	private Medecin medecin;
	private Date dateDebut;
	private Date dateFin;
	private double Salaire;
	private boolean isValide;
	private List<Medicament> medicaments;
	
	Contrat(){
		
	}
	

	public Contrat(Long idContrat, Labo labo, Medecin medecin, Date dateDebut,
			Date dateFin, double salaire, boolean isValide,
			List<Medicament> medicaments) {
		this.idContrat = idContrat;
		this.labo = labo;
		this.medecin = medecin;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		Salaire = salaire;
		this.isValide = isValide;
		this.medicaments = medicaments;
	}


	public Labo getLabo() {
		return labo;
	}

	public void setLabo(Labo labo) {
		this.labo = labo;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getSalaire() {
		return Salaire;
	}

	public void setSalaire(double salaire) {
		Salaire = salaire;
	}

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public Long getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(Long idContrat) {
		this.idContrat = idContrat;
	}

	public List<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}
	
	
	
	
	

}
