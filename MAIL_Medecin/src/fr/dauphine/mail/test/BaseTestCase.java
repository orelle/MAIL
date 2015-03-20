package fr.dauphine.mail.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;

import fr.dauphine.mail.util.HibernateUtil;

public class BaseTestCase extends DatabaseTestCase {

	protected Connection jdbcConnection;
	protected FlatXmlDataSet loadedDataSet;

	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		//SessionFactory sessionFactory = ((HibernateEntityManagerFactory) entityManagerFactory).getSessionFactory();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Properties properties = ((SessionFactoryImpl) sessionFactory).getProperties();
		String url = (String) properties.get("hibernate.connection.url");
		String username = (String) properties.get("hibernate.connection.username");
		String password = (String) properties.get("hibernate.connection.password");
		Class.forName("com.mysql.jdbc.Driver");
		jdbcConnection = DriverManager.getConnection(
				url, username, password);
		return new DatabaseConnection(jdbcConnection);
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		loadedDataSet = new FlatXmlDataSet(this.getClass().getClassLoader()
				.getResourceAsStream("dataset.xml"));
		return loadedDataSet;
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
