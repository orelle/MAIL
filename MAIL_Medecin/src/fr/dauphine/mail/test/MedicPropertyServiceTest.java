package fr.dauphine.mail.test;

import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Test;

import fr.dauphine.mail.entities.Medicament;
import fr.dauphine.mail.entities.MedicamentProperty;
import fr.dauphine.mail.service.MedicPropertyServiceImpl;
import fr.dauphine.mail.util.DateUtils;

public class MedicPropertyServiceTest extends BaseTestCase {
	
	private MedicPropertyServiceImpl service = new MedicPropertyServiceImpl();
	private String TABLE_NAME = "MEDICAMENTPROPERTY";

	@Test
	public void testFindById() {
		MedicamentProperty mp = service.findById(1L);
		assertNotNull(mp);
		assertEquals(1L, mp.getIdMP().longValue());
	}

	@Test
	public void testCount() throws DataSetException {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_NAME).getRowCount();
		assertEquals(rowCount, service.count());
	}

	@Test
	public void testCreate() {
		MedicamentProperty mp = new MedicamentProperty(10L, "2 pelilule par jour", MedicamentProperty.MedicPropertyType.DOSE);
		long beforeCount = service.count();
		service.create(mp);
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
		assertNull(service.findById(2L));
	}

	@Test
	public void testDelete() {
		long before = service.count();
		MedicamentProperty m = service.findById(2L);
		service.delete(m);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(2L));
	}

	@Test
	public void testGetAll() {
		List<MedicamentProperty> ls = service.getAll();
		int count = 0;
		if (ls != null) {
			count = ls.size();
		}
		assertEquals(service.count(), count);
	}

	@Test
	public void testFindByProperty() {
		MedicamentProperty m = service.findByProperty(MedicamentProperty.class, "libelle",
				"2 par jour");
		assertNotNull(m);
		assertEquals("2 par jour", m.getLibelle());
	}

	@Test
	public void testUpdate() {
		MedicamentProperty m = service.findById(2L);
		assertNotNull(m);
		m.setLibelle("3 par jour");
		service.update(m);
		m = service.findById(2L);
		assertNotNull(m);
		assertEquals("3 par jour", m.getLibelle());
	}

}
