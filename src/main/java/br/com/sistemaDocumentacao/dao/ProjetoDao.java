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
		String sql = "INSERT INTO projeto (nome, situacao) " + "values (?, ?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, projeto.getNome());
			pstm.setBoolean(2, projeto.isSituacao());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualizar(Projeto projeto) {
		String sql = "UPDATE projeto SET nome = ?, situacao = ? WHERE id_projeto = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, projeto.getNome());
			pstm.setBoolean(2, projeto.isSituacao());
			pstm.setInt(3, projeto.getId_projeto());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(int id_projeto) {
		String sql = "DELETE FROM projeto WHERE id_projeto = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id_projeto);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Projeto buscarPorId(int id) {
		String sql = "SELECT nome, situacao FROM projeto WHERE id_projeto = ?";
		Projeto projeto = null;
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					String nome = result.getString(1);
					boolean situacao = result.getBoolean(2);
					projeto = new Projeto();
					projeto.setId_projeto(id);
					projeto.setNome(nome);
					projeto.setSituacao(situacao);
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return projeto;
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
			throw new RuntimeException(e);
		}
		return projetos;
	}

	public List<Projeto> buscarPorNome(String nomeBuscado) {
		String sql = "SELECT id_projeto, nome, situacao FROM projeto WHERE nome LIKE ?";
		List<Projeto> projetos = new ArrayList<>();
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, "%"+nomeBuscado+"%");
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					Integer id = result.getInt(1);
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
			throw new RuntimeException(e);
		}
		return projetos;
	}

	public List<Projeto> buscarPorNomeESituacao(String nomeBuscado, boolean situacao) {
		String sql = "SELECT id_projeto, nome FROM projeto WHERE (nome LIKE ?) AND (situacao = ?)";
		List<Projeto> projetos = new ArrayList<>();
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, "%"+nomeBuscado+"%");
			pstm.setBoolean(2, situacao);
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					Integer id = result.getInt(1);
					String nome = result.getString(2);
					Projeto projeto = new Projeto();
					projeto.setId_projeto(id);
					projeto.setNome(nome);
					projeto.setSituacao(situacao);
					
					projetos.add(projeto);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return projetos;
	}

	public List<Projeto> listarPorSituacao(boolean situacao) {
		String sql = "SELECT id_projeto, nome FROM projeto WHERE situacao = ?";
		List<Projeto> projetos = new ArrayList<>();
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setBoolean(1, situacao);
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					Integer id = result.getInt(1);
					String nome = result.getString(2);
					Projeto projeto = new Projeto();
					projeto.setId_projeto(id);
					projeto.setNome(nome);
					projeto.setSituacao(situacao);
					
					projetos.add(projeto);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return projetos;
	}
}
