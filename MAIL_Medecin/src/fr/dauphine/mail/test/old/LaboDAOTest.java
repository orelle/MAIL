package fr.dauphine.mail.test.old;

import java.util.ArrayList;
import java.util.List;

import fr.dauphine.mail.entities.Labo;
import fr.dauphine.mail.entities.Medecin;
import fr.dauphine.mail.service.LaboServiceImpl;

public class LaboDAOTest {
	
	public static void main(String[] args) {
		LaboServiceImpl laboService = new LaboServiceImpl();
		Labo labo = new Labo();
        labo.setNom("lab2");
        labo.setIdLabo(2L);
        labo.setAdresse("adress");
        Medecin med1 = new Medecin();
        med1.setNom("obel");
        med1.setPrenom("ouissam");
        List<Medecin> lMed = new ArrayList<Medecin>();
        lMed.add(med1);
        //labo.setMedecins(lMed);
        //laboService.create(labo);
        //laboService.deleteById(2L);
		
	}
	

}
