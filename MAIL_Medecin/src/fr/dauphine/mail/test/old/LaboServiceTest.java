package fr.dauphine.mail.test.old;

import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

import fr.dauphine.mail.entities.Labo;
import fr.dauphine.mail.service.LaboServiceImpl;

public class LaboServiceTest extends DatabaseTestCase {

	private Connection jdbcConnection;
	private FlatXmlDataSet loadedDataSet;
	LaboServiceImpl laboService =  new LaboServiceImpl(); ;
	

	
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		jdbcConnection = DriverManager.getConnection(
				"jdbc:mysql://localhost/medecin", "root", "");
		return new DatabaseConnection(jdbcConnection);
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		loadedDataSet = new FlatXmlDataSet(this.getClass().getClassLoader()
				.getResourceAsStream("dataset.xml"));
		return loadedDataSet;
	}

	@Test
	public void testFindById(){
		Labo labo = laboService.findById(2L);
		assertEquals(new Long(2), labo.getIdLabo());
	}
	
	@Test
	public void testCount(){
		assertEquals(2, laboService.count());
	}
	
	/*@Test
	public void testCreate(){
		Labo labo = new Labo();
        labo.setNom("labTesst");
        labo.setIdLabo(10L);
        labo.setAdresse("adress");
		long beforeCount = laboService.count();
        laboService.create(labo);
        long afterCount = laboService.count();
        assertEquals(beforeCount+1 , afterCount);
		
	}*/
	@Test
	public void testDeleteByID(){
		
		long before = laboService.count();
		laboService.deleteById(2L);
		long after = laboService.count();
		assertEquals(before-1, after);
		assertNull(laboService.findById(2L));
	}
	@Test
	public void testFindById2(){
		Labo labo = laboService.findById(1L);
		assertNotNull(labo);
		assertEquals(1L, labo.getIdLabo().longValue());
	}
	
	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.NONE;
	}
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.CLEAN_INSERT;
	}
}
