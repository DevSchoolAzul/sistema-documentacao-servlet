package br.com.sistemaDocumentacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sistemaDocumentacao.modelo.Usuario;

public class UsuarioDao{
	private Connection connection;

	public UsuarioDao(Connection connection) {
		this.connection = connection;
	}
	
	public Usuario usuarioExiste(String email, String senha) {
		Usuario usuario = null;
		
		String sql = "SELECT * FROM usuario WHERE email = ? and senha = ?";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, email);
			pstm.setString(2, senha);
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					usuario = new Usuario();
					usuario.setId_usuario(rst.getInt(1));
					usuario.setNome(rst.getString(2));
					usuario.setEmail(rst.getString(3));
					usuario.setSenha(rst.getString(4));					
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return usuario;
	}
}
