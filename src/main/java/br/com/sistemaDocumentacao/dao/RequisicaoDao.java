package br.com.sistemaDocumentacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaDocumentacao.modelo.Requisicao;

public class RequisicaoDao {

	private Connection connection;

	public RequisicaoDao(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Requisicao requisicao) {
		String sql = "INSERT INTO requisicao (id_evento, url_homolog, uri_prod, descricao, requisicao_pai, camada, situacao, ordem)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, requisicao.getId_evento());
			pstm.setString(2, requisicao.getUrl_homolog());
			pstm.setString(3, requisicao.getUri_prod());
			pstm.setString(4, requisicao.getDescricao());
			if (requisicao.getRequisicao_pai() == null) {
				pstm.setNull(5, 0);
			} else {
				pstm.setInt(5, requisicao.getRequisicao_pai());
			}
			pstm.setString(6, requisicao.getCamada());
			pstm.setBoolean(7, requisicao.isSituacao());
			pstm.setInt(8, requisicao.getOrdem());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Requisicao buscarPorId(int id) {
		String sql = "SELECT id_evento, url_homolog, uri_prod, descricao, " 
				+ "requisicao_pai, camada, situacao, ordem "
				+ "FROM requisicao WHERE id_requisicao = ?";
		Requisicao requisicao = null;
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					requisicao = new Requisicao();
					requisicao.setId_requisicao(id);
					requisicao.setId_evento(rst.getInt(1));
					requisicao.setUrl_homolog(rst.getString(2));
					requisicao.setUri_prod(rst.getString(3));
					requisicao.setDescricao(rst.getString(4));
					requisicao.setRequisicao_pai(rst.getInt(5));
					requisicao.setCamada(rst.getString(6));
					requisicao.setSituacao(rst.getBoolean(7));
					requisicao.setOrdem(rst.getInt(8));
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return requisicao;
	}

	public void atualizar(Requisicao requisicao) {
		String sql = "UPDATE requisicao SET url_homolog = ?, uri_prod = ?, descricao = ?, "
				+ "requisicao_pai = ?, camada = ?, situacao = ?, ordem = ? "
				+ "WHERE id_requisicao = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, requisicao.getUrl_homolog());
			pstm.setString(2, requisicao.getUri_prod());
			pstm.setString(3, requisicao.getDescricao());
			if (requisicao.getRequisicao_pai() == null) {
				pstm.setNull(4, 0);
			} else {
				pstm.setInt(4, requisicao.getRequisicao_pai());
			}
			pstm.setString(5, requisicao.getCamada());
			pstm.setBoolean(6, requisicao.isSituacao());
			pstm.setInt(7, requisicao.getOrdem());
			pstm.setInt(8, requisicao.getId_requisicao());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(int id_requisicao) {
		String sql = "DELETE FROM requisicao WHERE ID_REQUISICAO = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id_requisicao);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Requisicao> listarRequisicoes() {
		List<Requisicao> requisicoes = new ArrayList<>();
		
		String sql = "SELECT * FROM requisicao";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try(ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Requisicao requisicao = new Requisicao();
					requisicao.setId_requisicao(rst.getInt(1));
					requisicao.setId_evento(rst.getInt(2));
					requisicao.setUrl_homolog(rst.getString(3));
					requisicao.setUri_prod(rst.getString(4));
					requisicao.setDescricao(rst.getString(5));
					requisicao.setRequisicao_pai(rst.getInt(6));
					requisicao.setCamada(rst.getString(7));
					requisicao.setSituacao(rst.getBoolean(8));
					requisicao.setOrdem(rst.getInt(9));
					
					requisicoes.add(requisicao);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return requisicoes;
	}

	public List<Requisicao> listarRequisicoesDoEvento(Integer id_evento) {

		List<Requisicao> requisicoes = new ArrayList<>();

		String sql = "SELECT * FROM requisicao WHERE ID_EVENTO = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id_evento);

			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Requisicao requisicao = new Requisicao();
					requisicao.setId_requisicao(rst.getInt(1));
					requisicao.setId_evento(rst.getInt(2));
					requisicao.setUrl_homolog(rst.getString(3));
					requisicao.setUri_prod(rst.getString(4));
					requisicao.setDescricao(rst.getString(5));
					requisicao.setRequisicao_pai(rst.getInt(6));
					requisicao.setCamada(rst.getString(7));
					requisicao.setSituacao(rst.getBoolean(8));
					requisicao.setOrdem(rst.getInt(9));
					requisicoes.add(requisicao);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return requisicoes;
	}
}
