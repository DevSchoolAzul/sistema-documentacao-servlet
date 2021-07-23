package br.com.sistemaDocumentacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaDocumentacao.modelo.Evento;

public class EventoDao {

	private Connection connection;
	
	public EventoDao(Connection connection) {
		this.connection = connection;
	}
	
	public void cadastrar(Evento evento) {
		String sql = "INSERT INTO evento ("
				+ "id_tipo_evento, id_tela, situacao , ordem, parametros) "
				+ "values (?, ?, ?, ?, ?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, evento.getId_tipo_evento());
			pstm.setInt(2, evento.getId_tela());
			pstm.setBoolean(3, evento.isSituacao());
			pstm.setInt(4, evento.getOrdem());
			pstm.setString(5, evento.getParametros());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualizar(Evento evento) {
		String sql = "UPDATE evento SET id_tipo_evento = ?, id_tela = ?, "
				+ "situacao = ?, ordem = ?, parametros = ?"
				+ " WHERE id_Evento = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, evento.getId_tipo_evento());
			pstm.setInt(2, evento.getId_tela());
			pstm.setBoolean(3, evento.isSituacao());
			pstm.setInt(4, evento.getOrdem());
			pstm.setString(5, evento.getParametros());
			pstm.setInt(6, evento.getOrdem());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(int id_evento) {
		String sql = "DELETE FROM evento WHERE id_evento = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id_evento);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Evento buscar(int id) {
		String sql = "SELECT id_tipo_evento, id_tela, situacao, ordem, parametros"
				+ " FROM evento WHERE id_evento = ?";
		Evento evento = null;
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			try(ResultSet result = pstm.getResultSet()) {
				while(result.next()) {
					evento = new Evento();
					evento.setId_evento(id);
					evento.setId_tipo_evento(result.getInt(1));
					evento.setId_tela(result.getInt(2));
					evento.setSituacao(result.getBoolean(3));
					evento.setOrdem(result.getInt(4));
					evento.setParametros(result.getString(5));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return evento;
	}

	public List<Evento> listarEventos() {
		List<Evento> eventos = new ArrayList<>();
		
		String sql = "SELECT * FROM evento";
		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try(ResultSet rst = pstm.getResultSet()) {
				while(rst.next()) {
					Evento evento = new Evento();
					evento.setId_evento(rst.getInt(1));
					evento.setId_tipo_evento(rst.getInt(2));
					evento.setId_tela(rst.getInt(3));
					evento.setSituacao(rst.getBoolean(4));
					evento.setOrdem(rst.getInt(5));
					evento.setParametros(rst.getString(6));
					eventos.add(evento);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return eventos;
	}
	
	public List<Evento> listarEventosDaTela(Integer id_tela) {

		List<Evento> eventos = new ArrayList<>();

		String sql = "SELECT * FROM requisicao WHERE ID_TELA = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id_tela);

			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Evento evento = new Evento();
					evento.setId_evento(rst.getInt(1));
					evento.setId_tipo_evento(rst.getInt(2));
					evento.setId_tela(rst.getInt(3));
					evento.setSituacao(rst.getBoolean(4));
					evento.setOrdem(rst.getInt(5));
					evento.setParametros(rst.getString(6));
					eventos.add(evento);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return eventos;
	}
}



