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

}
