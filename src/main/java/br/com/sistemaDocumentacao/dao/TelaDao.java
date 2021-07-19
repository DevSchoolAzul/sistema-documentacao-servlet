package br.com.sistemaDocumentacao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaDocumentacao.modelo.Tela;

public class TelaDao {

	private Connection connection;

	public TelaDao(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Tela tela) {
		String sql = "INSERT INTO tela (Id_versao,Data_Cadastro,Nome_Tela,Imagem,Situacao,Tela_Pai,Ordem,Url_log,Versao_Origem)"
				+ " " + "values (?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, tela.getIdVersao());
			pstm.setDate(2, Date.valueOf(tela.getDataCadastro()));
			pstm.setString(3, tela.getNomeTela());
			pstm.setString(4, tela.getImagem());
			pstm.setBoolean(5, tela.isSituacao());
			if (tela.getTelaPai() == 0) {
				pstm.setNull(6, 0);
			} else {
				pstm.setInt(6, tela.getTelaPai());
			}
			pstm.setInt(7, tela.getOrdem());
			pstm.setString(8, tela.getUrlLog());
			pstm.setInt(9, tela.getVersaoOrigem());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualizar(Tela tela) {
		String sql = "UPDATE tela SET  Id_versao = ?, Data_Cadastro = ?, Nome_Tela = ?, Imagem = ?,"
				+ " Situacao = ?, Tela_Pai = ?, Ordem = ?, Url_log = ? ,Versao_Origem = ? WHERE id_tela = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(10, tela.getIdTela());
			pstm.setInt(1, tela.getIdVersao());
			pstm.setDate(2, Date.valueOf(tela.getDataCadastro()));
			pstm.setString(3, tela.getNomeTela());
			pstm.setString(4, tela.getImagem());
			pstm.setBoolean(5, tela.isSituacao());
			if (tela.getTelaPai() == 0) {
				pstm.setNull(6, 0);
			} else {
				pstm.setInt(6, tela.getTelaPai());
			}
			pstm.setInt(7, tela.getOrdem());
			pstm.setString(8, tela.getUrlLog());
			pstm.setInt(9, tela.getVersaoOrigem());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(int id_tela) {
		String sql = "DELETE FROM tela WHERE id_tela = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id_tela);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Tela buscarPorId(int id) {
		String sql = "SELECT Id_versao, Data_Cadastro, Nome_Tela, Imagem, Situacao, "
				+ " Tela_Pai, Ordem, Url_log, Versao_Origem FROM tela WHERE id_tela = ? ";
		Tela tela = null;
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					Integer Id_versao = result.getInt(1);
					Date Data_Cadastro = result.getDate(2);
					String Nome_Tela = result.getString(3);
					String Imagem = result.getString(4);
					Boolean Situacao = result.getBoolean(5);
					Integer Tela_Pai = result.getInt(6);
					Integer Ordem = result.getInt(7);
					String Url_log = result.getString(8);
					Integer Versao_Origem = result.getInt(9);
					tela = new Tela();
					tela.setIdTela(id);
					tela.setIdVersao(Id_versao);
					tela.setDataCadastro(Data_Cadastro.toLocalDate());
					tela.setNomeTela(Nome_Tela);
					tela.setImagem(Imagem);
					tela.setSituacao(Situacao);
					tela.setTelaPai(Tela_Pai);
					tela.setOrdem(Ordem);
					tela.setUrlLog(Url_log);
					tela.setVersaoOrigem(Versao_Origem);
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return tela;
	}

	public List<Tela> listarTela() {
		String sql = "SELECT * FROM tela";
		List<Tela> telas = new ArrayList<>();
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					Integer Id_Tela = result.getInt(1);
					Integer Id_versao = result.getInt(2);
					Date Data_Cadastro = result.getDate(3);
					String Nome_Tela = result.getString(4);
					String Imagem = result.getString(5);
					Boolean Situacao = result.getBoolean(6);
					Integer Tela_Pai = result.getInt(7);
					Integer Ordem = result.getInt(8);
					String Url_log = result.getString(9);
					Integer Versao_Origem = result.getInt(10);
					Tela tela = new Tela();

					tela.setIdTela(Id_Tela);
					tela.setIdVersao(Id_versao);
					tela.setDataCadastro(Data_Cadastro.toLocalDate());
					tela.setNomeTela(Nome_Tela);
					tela.setImagem(Imagem);
					tela.setSituacao(Situacao);
					tela.setTelaPai(Tela_Pai);
					tela.setOrdem(Ordem);
					tela.setUrlLog(Url_log);
					tela.setVersaoOrigem(Versao_Origem);
					
					telas.add(tela);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return telas;
	}
	
	public List<Tela> listarTelaDeUmaVersao(int id_versao) {
		String sql = "SELECT * FROM tela WHERE id_versao = ?";
		List<Tela> telas = new ArrayList<>();
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id_versao);
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					Integer Id_Tela = result.getInt(1);
					Integer Id_versao = result.getInt(2);
					Date Data_Cadastro = result.getDate(3);
					String Nome_Tela = result.getString(4);
					String Imagem = result.getString(5);
					Boolean Situacao = result.getBoolean(6);
					Integer Tela_Pai = result.getInt(7);
					Integer Ordem = result.getInt(8);
					String Url_log = result.getString(9);
					Integer Versao_Origem = result.getInt(10);
					Tela tela = new Tela();

					tela.setIdTela(Id_Tela);
					tela.setIdVersao(Id_versao);
					tela.setDataCadastro(Data_Cadastro.toLocalDate());
					tela.setNomeTela(Nome_Tela);
					tela.setImagem(Imagem);
					tela.setSituacao(Situacao);
					tela.setTelaPai(Tela_Pai);
					tela.setOrdem(Ordem);
					tela.setUrlLog(Url_log);
					tela.setVersaoOrigem(Versao_Origem);
					
					telas.add(tela);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return telas;
	}
}
