package fr.dauphine.mail.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Test;

import fr.dauphine.mail.entities.Maladie;
import fr.dauphine.mail.entities.Medecin;
import fr.dauphine.mail.entities.Medicament;
import fr.dauphine.mail.entities.Patient;
import fr.dauphine.mail.entities.Symptome;
import fr.dauphine.mail.entities.Traitement;
import fr.dauphine.mail.service.MaladieServiceImpl;
import fr.dauphine.mail.service.MedecinServiceImpl;
import fr.dauphine.mail.service.MedicamentServiceImpl;
import fr.dauphine.mail.service.PatientServiceImpl;
import fr.dauphine.mail.service.SymptomeServiceImpl;
import fr.dauphine.mail.service.TraitementServiceImpl;

public class TraitementServiceTest extends BaseTestCase {
	
	private TraitementServiceImpl service = new TraitementServiceImpl();
	private String TABLE_NAME = "TRAITEMENT";

	@Test
	public void testFindById() {
		Traitement t = service.findById(1L);
		assertNotNull(t);
		assertEquals(1L, t.getIdTraitement().longValue());
	}

	@Test
	public void testCount() throws DataSetException {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_NAME).getRowCount();
		assertEquals(rowCount, service.count());
	}

	@Test
	public void testCreate() {
		MedecinServiceImpl medecinService = new MedecinServiceImpl();
		MaladieServiceImpl maladieService =  new MaladieServiceImpl();
		MedicamentServiceImpl medicService = new MedicamentServiceImpl();
		SymptomeServiceImpl sympService = new SymptomeServiceImpl();
		PatientServiceImpl patientService = new PatientServiceImpl();
		
		Medecin m = medecinService.findById(1L);
		Maladie maladie = maladieService.findById(1L);
		Medicament med = medicService.findById(1L);
		Symptome s = sympService.findById(1L);
		Patient p = patientService.findById(1L);
		assertNotNull(m);
		assertNotNull(maladie);
		assertNotNull(med);
		assertNotNull(s);
		assertNotNull(p);
		List<Medicament> lsMedic = new ArrayList<Medicament>();
		lsMedic.add(med);
		List<Symptome> lsSymp = new ArrayList<Symptome>();
		lsSymp.add(s);
		//Traitement t = new Traitement(10L, 60, new Date(), 5, m, p, maladie, lsMedic, lsSymp);
		Traitement t = new Traitement(10L, 60, new Date(), 5, null, null, null, null, null);
		long beforeCount = service.count();
		service.create(t);
		long afterCount = service.count();
		assertEquals(beforeCount + 1, afterCount);
		assertNotNull(service.findById(10L));
	}


	@Test
	public void testDelete() {
		long before = service.count();
		Traitement t = service.findById(1L);
		service.delete(t);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(1L));
		SymptomeServiceImpl symServiceImpl = new SymptomeServiceImpl();
		// on teste si les symtomes associés au traitement sont supprimés
		assertNull(symServiceImpl.findById(1L));
		assertNull(symServiceImpl.findById(2L));
	}

	@Test
	public void testGetAll() {
		List<Traitement> ls = service.getAll();
		int count = 0;
		if (ls != null) {
			count = ls.size();
		}
		assertEquals(service.count(), count);
	}

	@Test
	public void testUpdate() {
		Traitement t = service.findById(1L);
		assertNotNull(t);
		t.setDureeJours(120);
		service.update(t);
		t = service.findById(1L);
		assertNotNull(t);
		assertEquals(120, t.getDureeJours());
	}



}
