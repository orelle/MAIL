package fr.dauphine.mail.test;

import java.util.Date;
import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Test;

import fr.dauphine.mail.entities.Patient;
import fr.dauphine.mail.service.PatientServiceImpl;

public class PatientServiceTest extends BaseTestCase{
	private PatientServiceImpl service = new PatientServiceImpl();
	private String TABLE_NAME = "PATIENT";

	@Test
	public void testFindById() {
		Patient p = service.findById(1L);
		assertNotNull(p);
		assertEquals(1L, p.getIdPatient().longValue());
	}

	@Test
	public void testCount() throws DataSetException {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_NAME).getRowCount();
		assertEquals(rowCount, service.count());
	}

	@Test
	public void testCreate() {
		Patient p = new Patient(10L, "bel", "wissam", new Date(), "M", "073663636", "rue St Louis", "Paris", null);
		long beforeCount = service.count();
		service.create(p);
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
		Patient p = service.findById(2L);
		service.delete(p);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(2L));
	}

	@Test
	public void testGetAll() {
		List<Patient> ls = service.getAll();
		int count = 0;
		if (ls != null) {
			count = ls.size();
		}
		assertEquals(service.count(), count);
	}

	@Test
	public void testFindByProperty() {
		Patient p = service.findByProperty(Patient.class, "tel",
				"061234443");
		assertNotNull(p);
		assertEquals("061234443", p.getTel());
	}

	@Test
	public void testUpdate() {
		Patient m = service.findById(2L);
		assertNotNull(m);
		m.setAdresse("New address");
		service.update(m);
		m = service.findById(2L);
		assertNotNull(m);
		assertEquals("New address", m.getAdresse());
	}

}
