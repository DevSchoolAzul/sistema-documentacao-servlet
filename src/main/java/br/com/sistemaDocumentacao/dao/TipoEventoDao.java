package br.com.sistemaDocumentacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaDocumentacao.modelo.TipoEvento;

public class TipoEventoDao {

	private Connection connection;

	public TipoEventoDao(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(TipoEvento TipoEvento) {
		String sql = "INSERT INTO tipo_evento (nome, situacao) " + "values (?, ?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, TipoEvento.getNome());
			pstm.setBoolean(2, TipoEvento.isSituacao());

			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualizar(TipoEvento TipoEvento) {
		String sql = "UPDATE tipo_evento SET nome = ?, situacao = ? WHERE id_projeto = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, TipoEvento.getNome());
			pstm.setBoolean(2, TipoEvento.isSituacao());
			pstm.setInt(3, TipoEvento.getId_tipo_evento());

			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(int id_tipo_evento) {
		String sql = "DELETE FROM tipo_evento WHERE id_tipo_evento = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id_tipo_evento);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public TipoEvento buscarPorId(int id) {
		String sql = "SELECT nome, situacao FROM tipo_evento WHERE id_tipo_evento = ?";
		TipoEvento tipoEvento = null;
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					String nome = result.getString(1);
					boolean situacao = result.getBoolean(2);
					tipoEvento = new TipoEvento();
					tipoEvento.setId_tipo_evento(id);
					tipoEvento.setNome(nome);
					tipoEvento.setSituacao(situacao);
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println(tipoEvento);
		return tipoEvento;
	}

	public List<TipoEvento> listarTipoEventos() {
		String sql = "SELECT * FROM tipo_evento";
		List<TipoEvento> tipoEventos = new ArrayList<>();
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					int id = result.getInt(1);
					String nome = result.getString(2);
					boolean situacao = result.getBoolean(3);
					TipoEvento tipoEvento = new TipoEvento();
					tipoEvento.setId_tipo_evento(id);
					tipoEvento.setNome(nome);
					tipoEvento.setSituacao(situacao);
					tipoEventos.add(tipoEvento);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return tipoEventos;
	}
}
