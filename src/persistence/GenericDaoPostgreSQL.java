package persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GenericDaoPostgreSQL {
	private  Connection conn;

	public  Connection getConnection() throws SQLException {

		Properties props = loadProperties();
		String url = props.getProperty("dburl");
		conn = DriverManager.getConnection(url, props);

		return conn;
	}

	private  Properties loadProperties() {
		Properties props = null;
		try (FileInputStream fs = new FileInputStream("postgresql.properties")) {
			props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException erro) {
			erro.printStackTrace();
		}
		return props;
	}

}
