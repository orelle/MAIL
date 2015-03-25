package fr.dauphine.mail.test.old;

import java.util.List;

import fr.dauphine.mail.entities.Medicament;
import fr.dauphine.mail.entities.Patient;
import fr.dauphine.mail.entities.Symptome;
import fr.dauphine.mail.entities.Traitement;
import fr.dauphine.mail.service.PatientServiceImpl;

public class PatientDossierTest {
	
	
	public static void main(String[] args) {
		PatientServiceImpl patientService = new PatientServiceImpl();
		Patient p = patientService.findById(1L);
		System.out.println("########################");
		System.out.println("Nom et prénom : "+p.getNom()+" "+p.getPrenom());
		System.out.println("Liste des traitements");
		System.out.println("---------------------");
		List<Traitement> traits = p.getTraitements();
		for(int i=0; i<traits.size(); i++){
			Traitement t = traits.get(i);
			System.out.println("Medecin : "+t.getMedecin().getNom()+" "+t.getMedecin().getPrenom());
			System.out.println("Maladie : "+t.getMaladie().getLibelle());
			System.out.println("Medicaments : ");
			for(int j=0; j<t.getMedicaments().size(); j++){
				Medicament m = t.getMedicaments().get(j);
				System.out.println("\t"+m.getLibelle());
			}
			System.out.println("Symptomes : ");
			for(int k=0; k<t.getSymptomes().size(); k++){
				Symptome s = t.getSymptomes().get(k);
				System.out.println("\t"+s.getLibelle());
			}
		}
		
		
	}
	
}
