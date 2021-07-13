package br.com.sistemaDocumentacao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			new Driver();
			connection = DriverManager.getConnection("jdbc:mysql://localhost/sistema_documentacao?useTimezone=true&setTimezone=UTC", "brunno", "13081998");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
}
