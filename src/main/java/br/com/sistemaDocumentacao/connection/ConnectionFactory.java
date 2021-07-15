package br.com.sistemaDocumentacao.connection;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource combo;
	
	public ConnectionFactory() {
		try {
			ComboPooledDataSource combo = new ComboPooledDataSource();
			combo.setDriverClass("com.mysql.cj.jdbc.Driver");
			combo.setJdbcUrl("jdbc:mysql://localhost/sistema_documentacao?useTimezone=true&setTimezone=UTC");
			combo.setUser("root");
			combo.setPassword("root");
			this.combo = combo;
		} catch (PropertyVetoException e) {
			throw new RuntimeException("Erro ao setar o driver do banco de dados. " + e);
		}
		
	}
	
	public Connection getConnection() {
		try {
			return this.combo.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
