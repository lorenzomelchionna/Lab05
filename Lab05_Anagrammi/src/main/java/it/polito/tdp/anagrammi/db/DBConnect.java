package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class DBConnect {

	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=w la patata";
	
	static private HikariDataSource ds = null;
	
	public static Connection getConnection() {
		
		if(ds==null) {
			
			ds = new HikariDataSource();
			
			ds.setJdbcUrl(jdbcUrl);
			ds.setUsername("root");
			ds.setPassword("w la patata");
			
		}
		
		try {
			
				Connection connection = ds.getConnection();
				return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
			
		}
		
	}

}
