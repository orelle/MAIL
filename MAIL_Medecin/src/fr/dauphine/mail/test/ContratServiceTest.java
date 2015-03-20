package fr.dauphine.mail.test;

import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Test;

import fr.dauphine.mail.entities.Contrat;
import fr.dauphine.mail.entities.Labo;
import fr.dauphine.mail.entities.Medecin;
import fr.dauphine.mail.service.ContratServiceImpl;
import fr.dauphine.mail.service.LaboServiceImpl;
import fr.dauphine.mail.service.MedecinServiceImpl;
import fr.dauphine.mail.util.DateUtils;

public class ContratServiceTest extends BaseTestCase {

	private ContratServiceImpl service = new ContratServiceImpl();
	private String TABLE_NAME = "CONTRAT";
	
	@Test
	public void testFindById() {
		Contrat contrat = service.findById(1L);
		assertNotNull(contrat);
		assertEquals(1L, contrat.getIdContrat().longValue());
	}

	@Test
	public void testCount() throws DataSetException {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_NAME).getRowCount();
		assertEquals(rowCount, service.count());
	}

	@Test
	public void testCreate() {
		LaboServiceImpl laboService = new LaboServiceImpl();
		Labo labo = laboService.findById(1L);
		MedecinServiceImpl medService = new MedecinServiceImpl();
		Medecin medecin = medService.findById(1L);
		Contrat c = new Contrat(10L, labo, medecin, DateUtils.strToDate("01/01/2015"), DateUtils.strToDate("01/01/2016"),
				3000, true, null);
		long beforeCount = service.count();
		service.create(c);
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
		Contrat c = service.findById(3L);
		service.delete(c);
		long after = service.count();
		assertEquals(before - 1, after);
		assertNull(service.findById(3L));
	}

	@Test
	public void testGetAll() {
		List<Contrat> ls = service.getAll();
		int count = 0;
		if (ls != null) {
			count = ls.size();
		}
		assertEquals(service.count(), count);
	}

	@Test
	public void testFindByProperty() {
		Contrat c = service.findByProperty(Contrat.class, "idContrat", new Long(1));
		assertNotNull(c);
		assertEquals(c.getIdContrat().longValue(), 1);
	}

	@Test
	public void testUpdate() {
		Contrat c = service.findById(2L);
		assertNotNull(c);
		c.setSalaire(1234);
		service.update(c);
		c = service.findById(2L);
		assertNotNull(c);
		assertEquals(1234.0, c.getSalaire());
	}
	@Test
	public void testGetContartsByMedecin(){
		MedecinServiceImpl medService = new MedecinServiceImpl();
		Medecin m = medService.findById(1L);
		List<Contrat> lsContrats = service.getAllContratByMedecin(m);
		assertEquals(3, lsContrats.size());
	}
	
	@Test
	public void testGetContartsByLabo(){
		LaboServiceImpl laboService = new LaboServiceImpl();
		Labo labo = laboService.findById(1L);
		List<Contrat> lsContrats = service.getAllContratByLabo(labo);
		assertEquals(3, lsContrats.size());
	}
}
