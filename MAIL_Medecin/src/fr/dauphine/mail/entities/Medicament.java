package fr.dauphine.mail.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Medicament implements Serializable{

	private Long idMedic;
	private String libelle;
	private String description;
	private MedicamentEtat etat;
	private Date dateCreation;
	private List<MedicamentProperty> properties;
	private List<Contrat> contrats;
	private List<Maladie> maladies;
	
	public enum MedicamentEtat { EN_COURS, EN_TEST, VALIDE, EN_VENTE}

	public Medicament() {
	}
	
	

	public Medicament(Long idMedic, String libelle, String description,
			MedicamentEtat etat, Date dateCreation,
			List<MedicamentProperty> properties, List<Contrat> contrats,
			List<Maladie> maladies) {
		this.idMedic = idMedic;
		this.libelle = libelle;
		this.description = description;
		this.etat = etat;
		this.dateCreation = dateCreation;
		this.properties = properties;
		this.contrats = contrats;
		this.maladies = maladies;
	}



	public Long getIdMedic() {
		return idMedic;
	}

	public void setIdMedic(Long idMedic) {
		this.idMedic = idMedic;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<MedicamentProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<MedicamentProperty> properties) {
		this.properties = properties;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Contrat> getContrats() {
		return contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public Labo getLabo() {
		Labo labo = null;
		if (contrats != null && contrats.size() > 0) {
			labo = contrats.get(0).getLabo();
		}
		return labo;
	}
	
	public List<Medecin> getMedecins(){
		List<Medecin> list = new ArrayList<Medecin>();
		if(contrats != null && contrats.size() > 0)
		for(int i=0; i<contrats.size(); i++){
			list.add(contrats.get(i).getMedecin());
		}
		return list;
	}

	public List<Maladie> getMaladies() {
		return maladies;
	}

	public void setMaladies(List<Maladie> maladies) {
		this.maladies = maladies;
	}

	public MedicamentEtat getEtat() {
		return etat;
	}

	public void setEtat(MedicamentEtat etat) {
		this.etat = etat;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
 
}
