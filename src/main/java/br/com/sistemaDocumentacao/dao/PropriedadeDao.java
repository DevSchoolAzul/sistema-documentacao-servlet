package br.com.sistemaDocumentacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaDocumentacao.modelo.Propriedade;

public class PropriedadeDao {

	private Connection connection;
	
	public PropriedadeDao(Connection connection) {
		this.connection = connection;
	}
	
	public void cadastrar(Propriedade propriedade) {
		String sql = "INSERT INTO propriedade"
				+ "(id_requisicao, chave, valor, ordem) "
				+ "values (?, ?, ?, ?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, propriedade.getIdRequisicao());
			pstm.setString(2, propriedade.getChave());
			pstm.setString(3, propriedade.getValor());
			pstm.setInt(4, propriedade.getOrdem());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(Propriedade propriedade) {
		/* não coloquei pra alterar id_requisição pois não perece
		 correto alterar esse atributo */
		String sql = "UPDATE propriedade SET chave = ?, valor = ?, ordem = ?"
				+ " WHERE id_propriedade = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, propriedade.getChave());
			pstm.setString(2, propriedade.getValor());
			pstm.setInt(3, propriedade.getOrdem());
			pstm.setInt(4, propriedade.getIdPropriedade());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(int idPropriedade) {
		String sql = "DELETE FROM propriedade WHERE id_propriedade = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, idPropriedade);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Propriedade buscarPorId(int id) {
		String sql = "SELECT id_requisicao, chave, valor, ordem FROM propriedade"
				+ " WHERE id_propriedade = ?";
		Propriedade propriedade = null;
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					Integer idRequisicao = result.getInt(1);
					String chave = result.getString(2);
					String valor = result.getString(3);
					Integer ordem = result.getInt(4);
					propriedade = new Propriedade();
					propriedade.setIdPropriedade(id);
					propriedade.setIdRequisicao(idRequisicao);
					propriedade.setChave(chave);
					propriedade.setValor(valor);
					propriedade.setOrdem(ordem);
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return propriedade;
	}
	
	public List<Propriedade> ListarPropriedades() {
		String sql = "SELECT id_propriedade, id_requisicao, chave, valor, ordem "
				+ "FROM propriedade";
		List<Propriedade> propriedades = new ArrayList<>();
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try(ResultSet result = pstm.getResultSet()) {
				while(result.next()) {
					Integer idPropriedade = result.getInt(1);
					Integer idRequisicao = result.getInt(2);
					String chave = result.getString(3);
					String valor = result.getString(4);
					Integer ordem = result.getInt(5);
					Propriedade propriedade = new Propriedade();
					propriedade.setIdPropriedade(idPropriedade);
					propriedade.setIdRequisicao(idRequisicao);
					propriedade.setChave(chave);
					propriedade.setValor(valor);
					propriedade.setOrdem(ordem);
					
					propriedades.add(propriedade);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propriedades;
	}
}
