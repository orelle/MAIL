package fr.dauphine.mail.test;

import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Test;

import fr.dauphine.mail.entities.Labo;
import fr.dauphine.mail.service.LaboServiceImpl;

public class LaboServiceTest extends BaseTestCase {

	private LaboServiceImpl service = new LaboServiceImpl();
	private String TABLE_NAME = "LABO";

	@Test
	public void testFindById() {
		Labo labo = service.findById(1L);
		assertNotNull(labo);
		assertEquals(1L, labo.getIdLabo().longValue());
	}

	@Test
	public void testCount() throws DataSetException {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_NAME).getRowCount();
		assertEquals(rowCount, service.count());
	}

	@Test
	public void testCreate() {
		Labo labo = new Labo(10L, "new Labo", "1 rue JFK", "Paris");
		long beforeCount = service.count();
		service.create(labo);
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
		Labo labo = service.findById(2L);
		service.delete(labo);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(2L));
	}

	@Test
	public void testGetAll() {
		List<Labo> ls = service.getAll();
		int count = 0;
		if (ls != null) {
			count = ls.size();
		}
		assertEquals(service.count(), count);
	}

	@Test
	public void testFindByProperty() {
		Labo labo = service.findByProperty(Labo.class, "nom", "HLAB");
		assertNotNull(labo);
		assertEquals(labo.getNom(), "HLAB");
	}

	@Test
	public void testUpdate() {
		Labo labo = service.findById(2L);
		assertNotNull(labo);
		labo.setAdresse("new Address");
		service.update(labo);
		labo = service.findById(2L);
		assertNotNull(labo);
		assertEquals("new Address", labo.getAdresse());
	}

}
