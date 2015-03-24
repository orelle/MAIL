package fr.dauphine.mail.test;

import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Test;

import fr.dauphine.mail.entities.Maladie;
import fr.dauphine.mail.service.MaladieServiceImpl;

public class MaladieServiceTest extends BaseTestCase  {
	
	private MaladieServiceImpl service = new MaladieServiceImpl();
	private String TABLE_NAME = "MALADIE";

	@Test
	public void testFindById() {
		Maladie maladie = service.findById(1L);
		assertNotNull(maladie);
		assertEquals(1L, maladie.getIdMaladie().longValue());
	}

	@Test
	public void testCount() throws DataSetException {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_NAME).getRowCount();
		assertEquals(rowCount, service.count());
	}

	@Test
	public void testCreate() {
		Maladie maladie = new Maladie(10L, "Grippe", "descr", null );
		long beforeCount = service.count();
		service.create(maladie);
		long afterCount = service.count();
		assertEquals(beforeCount + 1, afterCount);
		assertNotNull(service.findById(10L));
	}

	@Test
	public void testDeleteByID() {
		long before = service.count();
		service.deleteById(3L);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(3L));
	}

	@Test
	public void testDelete() {
		long before = service.count();
		Maladie m = service.findById(3L);
		service.delete(m);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(3L));
	}

	@Test
	public void testGetAll() {
		List<Maladie> ls = service.getAll();
		int count = 0;
		if (ls != null) {
			count = ls.size();
		}
		assertEquals(service.count(), count);
	}

	@Test
	public void testFindByProperty() {
		Maladie m = service.findByProperty(Maladie.class, "libelle",
				"Virus X");
		assertNotNull(m);
		assertEquals("Virus X", m.getLibelle());
	}

	@Test
	public void testUpdate() {
		Maladie m = service.findById(2L);
		assertNotNull(m);
		m.setDescription("New description");
		service.update(m);
		m = service.findById(2L);
		assertNotNull(m);
		assertEquals("New description", m.getDescription());
	}


}
