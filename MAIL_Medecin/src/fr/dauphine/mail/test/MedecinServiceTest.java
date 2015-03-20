package fr.dauphine.mail.test;

import java.util.ArrayList;
import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Test;

import fr.dauphine.mail.entities.Contrat;
import fr.dauphine.mail.entities.Medecin;
import fr.dauphine.mail.entities.Medicament;
import fr.dauphine.mail.service.MedecinServiceImpl;
import fr.dauphine.mail.util.DateUtils;

public class MedecinServiceTest extends BaseTestCase {
	private MedecinServiceImpl service = new MedecinServiceImpl();
	private String TABLE_NAME = "MEDECIN";

	@Test
	public void testFindById() {
		Medecin medecin = service.findById(1L);
		assertNotNull(medecin);
		assertEquals(1L, medecin.getIdMedecin().longValue());
	}

	@Test
	public void testCount() throws DataSetException {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_NAME).getRowCount();
		assertEquals(rowCount, service.count());
	}

	@Test
	public void testCreate() {
		Medecin medecin = new Medecin(10L, "BELHADI", "Morad",
				DateUtils.strToDate("12/12/1980"), "0138834455",
				"belmo@hotmail.fr", "Chirugien", "123 rue Ferrer", "Lille",
				null);
		long beforeCount = service.count();
		service.create(medecin);
		long afterCount = service.count();
		assertEquals(beforeCount + 1, afterCount);
		assertNotNull(service.findById(10L));
	}

	@Test
	public void testDeleteByID() {
		long before = service.count();
		service.deleteById(2L);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(3L));
	}

	@Test
	public void testDelete() {
		long before = service.count();
		Medecin med = service.findById(2L);
		service.delete(med);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(3L));
	}

	@Test
	public void testGetAll() {
		List<Medecin> ls = service.getAll();
		int count = 0;
		if (ls != null) {
			count = ls.size();
		}
		assertEquals(service.count(), count);
	}

	@Test
	public void testFindByProperty() {
		Medecin m = service.findByProperty(Medecin.class, "email",
				"ouissam.belhadi@gmail.com");
		assertNotNull(m);
		assertEquals("ouissam.belhadi@gmail.com", m.getEmail());
	}

	@Test
	public void testUpdate() {
		Medecin m = service.findById(2L);
		assertNotNull(m);
		m.setSpecialite("Neurologue");
		service.update(m);
		m = service.findById(2L);
		assertNotNull(m);
		assertEquals("Neurologue", m.getSpecialite());
	}

	@Test
	public void testListeContratLabo() {
		Medecin m = service.findById(1L);
		assertNotNull(m);
		List<Contrat> ls = service.getContrats(m);
		assertNotNull(ls);
		assertEquals(3, ls.size());
	}

	@Test
	public void testListMedicamentDeveloppe() {
		Medecin m = service.findById(1L);
		assertNotNull(m);
		List<Contrat> ls = service.getContrats(m);
		assertNotNull(ls);
		List<Medicament> lsMedic = new ArrayList<Medicament>();
		for (int i = 0; i < ls.size(); i++) {
			lsMedic.addAll(ls.get(i).getMedicaments());
		}
		assertEquals(2, lsMedic.size());
	}

	@Test
	public void testListTraitementPatient() {
		Medecin m = service.findById(1L);
		assertNotNull(m);
		assertEquals(2, m.getTraitements().size());

	}

}
