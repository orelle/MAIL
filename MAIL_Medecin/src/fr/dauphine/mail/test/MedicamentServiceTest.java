package fr.dauphine.mail.test;

import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Test;

import fr.dauphine.mail.entities.Maladie;
import fr.dauphine.mail.entities.Medicament;
import fr.dauphine.mail.service.MedicPropertyServiceImpl;
import fr.dauphine.mail.service.MedicamentServiceImpl;
import fr.dauphine.mail.util.DateUtils;

public class MedicamentServiceTest extends BaseTestCase {
	
	private MedicamentServiceImpl service = new MedicamentServiceImpl();
	private String TABLE_NAME = "MEDICAMENT";

	@Test
	public void testFindById() {
		Medicament m = service.findById(1L);
		assertNotNull(m);
		assertEquals(1L, m.getIdMedic().longValue());
	}

	@Test
	public void testCount() throws DataSetException {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_NAME).getRowCount();
		assertEquals(rowCount, service.count());
	}

	@Test
	public void testCreate() {
		Medicament medicament = new Medicament(10L, "Actifed", "description", Medicament.MedicamentEtat.EN_VENTE, DateUtils.strToDate("01/01/2015"), null, null, null);
		long beforeCount = service.count();
		service.create(medicament);
		long afterCount = service.count();
		assertEquals(beforeCount + 1, afterCount);
		assertNotNull(service.findById(10L));
	}

	@Test
	public void testDeleteByID() {
		long before = service.count();
		service.deleteById(4L);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(4L));
		MedicPropertyServiceImpl mpService = new MedicPropertyServiceImpl();
		assertNull(mpService.findById(4L));
	}

	@Test
	public void testDelete() {
		long before = service.count();
		Medicament m = service.findById(4L);
		service.delete(m);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(4L));
		MedicPropertyServiceImpl mpService = new MedicPropertyServiceImpl();
		assertNull(mpService.findById(4L));
	}

	@Test
	public void testGetAll() {
		List<Medicament> ls = service.getAll();
		int count = 0;
		if (ls != null) {
			count = ls.size();
		}
		assertEquals(service.count(), count);
	}

	@Test
	public void testFindByProperty() {
		Medicament m = service.findByProperty(Medicament.class, "libelle",
				"Catex");
		assertNotNull(m);
		assertEquals("Catex", m.getLibelle());
	}

	@Test
	public void testUpdate() {
		Medicament m = service.findById(2L);
		assertNotNull(m);
		m.setDescription("New description medic");
		service.update(m);
		m = service.findById(2L);
		assertNotNull(m);
		assertEquals("New description medic", m.getDescription());
	}

}
