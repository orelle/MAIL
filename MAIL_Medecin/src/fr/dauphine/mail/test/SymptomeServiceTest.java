package fr.dauphine.mail.test;

import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Test;

import fr.dauphine.mail.entities.Symptome;
import fr.dauphine.mail.service.SymptomeServiceImpl;

public class SymptomeServiceTest  extends BaseTestCase{
	
	private SymptomeServiceImpl service = new SymptomeServiceImpl();
	private String TABLE_NAME = "SYMPTOME";

	@Test
	public void testFindById() {
		Symptome s = service.findById(1L);
		assertNotNull(s);
		assertEquals(1L, s.getIdSymptome().longValue());
	}

	@Test
	public void testCount() throws DataSetException {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_NAME).getRowCount();
		assertEquals(rowCount, service.count());
	}

	@Test
	public void testCreate() {
		Symptome s = new Symptome(10L, "libelle", null);
		long beforeCount = service.count();
		service.create(s);
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
		Symptome s = service.findById(2L);
		service.delete(s);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(2L));
	}

	@Test
	public void testGetAll() {
		List<Symptome> ls = service.getAll();
		int count = 0;
		if (ls != null) {
			count = ls.size();
		}
		assertEquals(service.count(), count);
	}

	@Test
	public void testFindByProperty() {
		Symptome s = service.findByProperty(Symptome.class, "libelle",
				"Trouble de sommeil");
		assertNotNull(s);
		assertEquals("Trouble de sommeil", s.getLibelle());
	}

	@Test
	public void testUpdate() {
		Symptome m = service.findById(2L);
		assertNotNull(m);
		m.setLibelle("new label");
		service.update(m);
		m = service.findById(2L);
		assertNotNull(m);
		assertEquals("new label", m.getLibelle());
	}


}
