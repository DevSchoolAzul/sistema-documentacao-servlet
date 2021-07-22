package br.com.sistemaDocumentacao.dao;

import java.sql.Connection;
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
	
	public List<Versao> listarVersoesDoProjeto(int id_projeto) {
		String sql = "SELECT "
				+ "id_versao, gmud, descricao, data_lancamento, situacao, ordem, numero_versao"
				+ " FROM versao WHERE id_projeto = ?";
		List<Versao> versoes = new ArrayList();
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

	public List<Versao> listarVersoes() {
		String sql = "SELECT "
				+ "id_versao, id_projeto, gmud, descricao, data_lancamento, situacao, ordem, numero_versao"
				+ " FROM versao";
		List<Versao> versoes = new ArrayList<>();
		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try(ResultSet result = pstm.getResultSet();) {
				while(result.next()) {
					int idVersao = result.getInt(1);
					int idProjeto = result.getInt(2);
					String gmud = result.getString(3);
					String descricao = result.getString(4);
					LocalDate dataLancamento = LocalDate.parse(result.getString(5));
					boolean situacao = result.getBoolean(6);
					int ordem = result.getInt(7);
					String numeroVersao = result.getString(8);
					Versao versao = new Versao();
					versao.setId_versao(idVersao);
					versao.setId_projeto(idProjeto);
					versao.setDescricao(descricao);
					versao.setGmud(gmud);
					versao.setData_lancamento(dataLancamento);
					versao.setSituacao(situacao);
					versao.setOrdem(ordem);
					versao.setNumero_versao(numeroVersao);
					
					versoes.add(versao);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return versoes;
	}

	public List<Versao> listarVersoesDoProjetoComSituacao(Integer idProjeto, boolean situacao) {
		String sql = "SELECT "
				+ "id_versao, gmud, descricao, data_lancamento, ordem, numero_versao"
				+ " FROM versao WHERE id_projeto = ? AND situacao = ?";
		List<Versao> versoes = new ArrayList<>();
		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try(ResultSet result = pstm.getResultSet();) {
				while(result.next()) {
					int idVersao = result.getInt(1);
					String gmud = result.getString(2);
					String descricao = result.getString(3);
					LocalDate dataLancamento = LocalDate.parse(result.getString(4));
					int ordem = result.getInt(5);
					String numeroVersao = result.getString(6);
					Versao versao = new Versao();
					versao.setId_versao(idVersao);
					versao.setId_projeto(idProjeto);
					versao.setDescricao(descricao);
					versao.setGmud(gmud);
					versao.setData_lancamento(dataLancamento);
					versao.setSituacao(situacao);
					versao.setOrdem(ordem);
					versao.setNumero_versao(numeroVersao);
					
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
