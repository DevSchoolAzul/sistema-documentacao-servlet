package br.com.sistemaDocumentacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaDocumentacao.modelo.Projeto;

public class ProjetoDao {

	private Connection connection;
	
	public ProjetoDao(Connection connection) {
		this.connection = connection;
	}
	
	public void cadastrar(Projeto projeto) {
		String sql = "INSERT INTO projeto (nome, situacao) "
				+ "values (?, ?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, projeto.getNome());
			pstm.setBoolean(2, projeto.isSituacao());
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(Projeto projeto) {
		
	}
	
	public void excluir(Projeto projeto) {
		
	}
	
	public List<Projeto> listarProjetos() {
		String sql = "SELECT * FROM projeto";
		List<Projeto> projetos = new ArrayList<>();
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					int id = result.getInt(1);
					String nome = result.getString(2);
					boolean situacao = result.getBoolean(3);
					Projeto projeto = new Projeto();
					projeto.setId_projeto(id);
					projeto.setNome(nome);
					projeto.setSituacao(situacao);
					projetos.add(projeto);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projetos;
	}
}
