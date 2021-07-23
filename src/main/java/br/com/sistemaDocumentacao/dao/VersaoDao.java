package br.com.sistemaDocumentacao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaDocumentacao.modelo.Versao;

public class VersaoDao {

	private Connection connection;

	public VersaoDao(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Versao versao) {
		String sql = "INSERT INTO versao (id_projeto, gmud, descricao, data_lancamento, situacao, ordem, numero_versao) "
				+ "values(?,?,?,?,?,?,?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, versao.getId_projeto());
			pstm.setString(2, versao.getGmud());
			pstm.setString(3, versao.getDescricao());
			pstm.setDate(4, Date.valueOf(versao.getData_lancamento()));
			pstm.setBoolean(5, versao.isSituacao()); // boolean usa is ao inv�s de get
			pstm.setInt(6, versao.getOrdem());
			pstm.setString(7, versao.getNumero_versao());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualizar(Versao versao) {
		String sql = "UPDATE versao SET id_projeto = ?, gmud = ?, descricao = ?, data_lancamento = ?, situacao = ?, ordem = ?, numero_versao = ? WHERE id_versao = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, versao.getId_projeto());
			pstm.setString(2, versao.getGmud());
			pstm.setString(3, versao.getDescricao());
			pstm.setDate(4, Date.valueOf(versao.getData_lancamento()));
			pstm.setBoolean(5, versao.isSituacao());
			pstm.setInt(6, versao.getOrdem());
			pstm.setString(7, versao.getNumero_versao());
			pstm.setInt(8, versao.getId_versao());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(int id_versao) {
		String sql = "DELETE FROM versao WHERE id_versao = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id_versao);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Versao buscarPorId(int id) {
		String sql = "SELECT id_projeto, gmud, descricao, data_lancamento, situacao, ordem, numero_versao FROM versao WHERE id_versao = ?";
		Versao versao = null; // no caso do id passado inexistir, � retornado um null
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					String numero_versao = result.getString(7); // revisar
					boolean situacao = result.getBoolean(5);
					int id_projeto = result.getInt(1);
					String gmud = result.getString(2);
					String descricao = result.getString(3);
					LocalDate dataLancamento = result.getDate(4).toLocalDate();
					int ordem = result.getInt(6);
					versao = new Versao();
					versao.setNumero_versao(numero_versao);
					versao.setId_versao(id);
					versao.setId_projeto(id_projeto);
					versao.setSituacao(situacao);
					versao.setGmud(gmud);
					versao.setDescricao(descricao);
					versao.setData_lancamento(dataLancamento);
					versao.setOrdem(ordem);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return versao;
	}

	public List<Versao> listarVersoes() {
		String sql = "SELECT * FROM versao";
		List<Versao> versoes = new ArrayList<>();
		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try(ResultSet result = pstm.getResultSet();) {
				while(result.next()) {
					int id_versao = result.getInt(1);
					int id_projeto = result.getInt(2);
					String gmud = result.getString(3);
					String descricao = result.getString(4);
					LocalDate data_lancamento = LocalDate.parse(result.getString(5));
					boolean situacao = result.getBoolean(6);
					int ordem = result.getInt(7);
					String numero_versao = result.getString(8);
					Versao versao = new Versao();
					versao.setId_versao(id_versao);
					versao.setId_projeto(id_projeto);
					versao.setDescricao(descricao);
					versao.setGmud(gmud);
					versao.setData_lancamento(data_lancamento);
					versao.setSituacao(situacao);
					versao.setOrdem(ordem);
					versao.setNumero_versao(numero_versao);
					versoes.add(versao);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return versoes;
	}
	
	public List<Versao> listarVersoesDoProjeto(int id_projeto) {
		String sql = "SELECT "
				+ "id_versao, gmud, descricao, data_lancamento, situacao, ordem, numero_versao"
				+ " FROM versao WHERE id_projeto = ?";
		List<Versao> versoes = new ArrayList<>();
		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id_projeto);
			pstm.execute();
			try(ResultSet result = pstm.getResultSet();) {
				while(result.next()) {
					int id_versao = result.getInt(1);
					String gmud = result.getString(2);
					String descricao = result.getString(3);
					LocalDate data_lancamento = LocalDate.parse(result.getString(4));
					boolean situacao = result.getBoolean(5);
					int ordem = result.getInt(6);
					String numero_versao = result.getString(7);
					Versao versao = new Versao();
					versao.setId_versao(id_versao);
					versao.setId_projeto(id_projeto);
					versao.setDescricao(descricao);
					versao.setGmud(gmud);
					versao.setData_lancamento(data_lancamento);
					versao.setSituacao(situacao);
					versao.setOrdem(ordem);
					versao.setNumero_versao(numero_versao);
					versoes.add(versao);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return versoes;
	}

}
