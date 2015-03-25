package fr.dauphine.mail.test.old;

import java.util.List;

import fr.dauphine.mail.entities.Contrat;
import fr.dauphine.mail.entities.Medecin;
import fr.dauphine.mail.entities.Medicament;
import fr.dauphine.mail.entities.Traitement;
import fr.dauphine.mail.service.ContratServiceImpl;
import fr.dauphine.mail.service.MedecinServiceImpl;
import fr.dauphine.mail.util.DateUtils;

public class MedecinResumeTest {
	
	public static void main(String[] args) {
		
		 MedecinServiceImpl medService = new MedecinServiceImpl();
		 ContratServiceImpl contratService = new ContratServiceImpl();
		 
		 Medecin medecin = medService.findById(1L);
		 System.out.println("########################");
		 System.out.println("Medecin : "+medecin.getPrenom()+" "+medecin.getNom());
		 System.out.println("Specialité : "+medecin.getSpecialite());
		 List<Contrat> contrats = contratService.getAllContratByMedecin(medecin);
		 for(int i=0;i<contrats.size();i++){
			 Contrat c = contrats.get(i);
			 System.out.println("-------------------");
			 System.out.println("\tLabo : "+ c.getLabo().getNom());
			 System.out.println("\tDébut contrat : "+ DateUtils.dateToStr(c.getDateDebut())+
					 " , date fin : "+DateUtils.dateToStr(c.getDateFin()));
			 List<Medicament> meds = c.getMedicaments();
			 if(meds.size()>0)
			 System.out.println("\tMedicaments:");
			 for(int j=0;j<meds.size();j++){
				 Medicament med = meds.get(j);
				 System.out.println("\t\tnom : "+med.getLibelle()+", etat : "+med.getEtat());
			 }
			 
		 }
		 System.out.println("########################");
		 System.out.println("Traitements : ");
		 List<Traitement> lsTrait = medecin.getTraitements();
		 for(int i=0; i<lsTrait.size();i++){
			 Traitement t = lsTrait.get(i);
			 System.out.println("\t-------------------");
			 System.out.println("\tPatient : "+t.getPatient().getPrenom()+" "+t.getPatient().getNom());
			 System.out.println("\tMaladie : "+t.getMaladie().getLibelle());
			 System.out.println("\tDate début : "+DateUtils.dateToStr(t.getDateDebut())+" , durée : "+t.getDureeJours());
			 System.out.println("\tProgrès : "+t.getProgres());
		 }
		
		
	}

}
