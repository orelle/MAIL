package fr.dauphine.mail.test.old;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.dauphine.mail.entities.Contrat;
import fr.dauphine.mail.entities.Labo;
import fr.dauphine.mail.entities.Medecin;
import fr.dauphine.mail.entities.Medicament;
import fr.dauphine.mail.entities.MedicamentProperty;
import fr.dauphine.mail.service.ContratServiceImpl;
import fr.dauphine.mail.service.LaboServiceImpl;
import fr.dauphine.mail.service.MaladieServiceImpl;
import fr.dauphine.mail.service.MedecinServiceImpl;
import fr.dauphine.mail.service.MedicPropertyServiceImpl;
import fr.dauphine.mail.service.MedicamentServiceImpl;
import fr.dauphine.mail.service.PatientServiceImpl;
import fr.dauphine.mail.service.SymptomeServiceImpl;
import fr.dauphine.mail.service.TraitementServiceImpl;

public class CreateData {
	
	public static void main(String[] args) {
		
		LaboServiceImpl laboServiceImpl = new LaboServiceImpl();
		ContratServiceImpl contratServiceImpl = new ContratServiceImpl();
		MaladieServiceImpl maladieServiceImpl = new MaladieServiceImpl();
		MedecinServiceImpl medecinServiceImpl = new MedecinServiceImpl();
		MedicamentServiceImpl medicamentServiceImpl = new MedicamentServiceImpl();
		MedicPropertyServiceImpl medicPropertyServiceImpl = new MedicPropertyServiceImpl();
		PatientServiceImpl patientServiceImpl = new PatientServiceImpl();
		SymptomeServiceImpl symptomeServiceImpl = new SymptomeServiceImpl();
		TraitementServiceImpl traitementServiceImpl = new TraitementServiceImpl();
		
		Labo labo = new Labo(1L, "GoodHealth", "14 rue Paraguay", "Paris");
		//laboServiceImpl.create(labo);
		
		Medecin medicin = new Medecin(1L, "nom", "prenom", new Date(), "tel", "email", "specialite", "adresse", "ville", null);
		//medecinServiceImpl.create(medicin);
		
		MedicamentProperty medProp1 = new MedicamentProperty(2L, "libelle2", MedicamentProperty.MedicPropertyType.INDICATION);
	    medicPropertyServiceImpl.create(medProp1);
		List<MedicamentProperty> medpl = new ArrayList<MedicamentProperty>();
		medpl.add(medProp1);
		
		Medicament med = new Medicament(2L, "libelle2", "description2", Medicament.MedicamentEtat.EN_VENTE, new Date(), medpl, null, null);
		medicamentServiceImpl.create(med);
		
		List<Medicament> medList = new ArrayList<Medicament>();
		medList.add(med);
        Contrat contrat = new Contrat(2L, labo, medicin, new Date(), new Date(), 2000, true, medList);
		List<Contrat> contList = new ArrayList<Contrat>();
		contList.add(contrat);
		contratServiceImpl.create(contrat);
		med.setContrats(contList);
		medicamentServiceImpl.update(med);
		
		
		
		
		
		
	}

}
