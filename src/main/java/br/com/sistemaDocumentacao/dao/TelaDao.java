package br.com.sistemaDocumentacao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			pstm.setInt(1, tela.getId_versao());
			pstm.setDate(2, (Date) tela.getData_Cadastro());
			pstm.setString(3, tela.getNome_Tela());
			pstm.setString(4,tela.getImagem());
			pstm.setBoolean(5,tela.isSituacao());
			pstm.setInt(6, tela.getTela_Pai());
			pstm.setInt(7, tela.getOrdem());
			pstm.setString(8, tela.getUrl_log());
			pstm.setInt(9, tela.getVersao_Origem());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(Tela tela) {
		String sql = "UPDATE tela SET  Id_versao = ?, Data_Cadastro = ?, Nome_Tela = ?, Imagem = ?,"
				+ " Situacao = ?, Tela_Pai = ?, Ordem = ?, Url_log = ? ,Versao_Origem = ? WHERE id_tela = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(10, tela.getId_tela());
			pstm.setInt(1, tela.getId_versao());
			pstm.setDate(2, (Date) tela.getData_Cadastro());
			pstm.setString(3, tela.getNome_Tela());
			pstm.setString(4,tela.getImagem());
			pstm.setBoolean(5,tela.isSituacao());
			pstm.setInt(6, tela.getTela_Pai());
			pstm.setInt(7, tela.getOrdem());
			pstm.setString(8, tela.getUrl_log());
			pstm.setInt(9, tela.getVersao_Origem());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(int id_tela) {
		String sql = "DELETE FROM tela WHERE id_tela = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1,id_tela);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

	public  Tela buscarPorId(int id) {
		String sql = "SELECT Id_versao,Data_Cadastro,Nome_Tela,Imagem,Situacao,Tela_Pai,Ordem,Url_log,Versao_Origem"
				+ " FROM projeto WHERE id_tela = ?";
		Tela tela = null;
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					String Id_Tela = result.getString(1);
					String Id_versao = result.getString(2);
					Date Data_Cadastro = result.getDate(3);
					String Nome_Tela = result.getString(4);
					String Imagem = result.getString(5);
					Boolean Situacao = result.getBoolean(6);
					Integer Tela_Pai = result.getInt(7);
					Integer Ordem = result.getInt(8);
					String Url_log = result.getString(9);
					Integer Versao_Origem= result.getInt(10);		
					tela = new Tela();
					tela.setId_tela(id);
					tela.setId_versao(id);
					tela.setData_Cadastro(Data_Cadastro);
					tela.setNome_Tela(Nome_Tela);
					tela.setImagem(Imagem);
					tela.setSituacao(Situacao);
					tela.setTela_Pai(Tela_Pai);
					tela.setOrdem(Ordem);
					tela.setUrl_log(Url_log);
					tela.setVersao_Origem(Versao_Origem);
				}
			}
			
			}
				catch (SQLException e) {
					throw new RuntimeException(e);
		   }
				System.out.println(tela);
					return tela;
	}
		
	public List<Tela> listarTela() {
		String sql = "SELECT * FROM tela";
		List<Tela> telas = new ArrayList<>();
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					String Id_Tela = result.getString(1);
					String Id_versao = result.getString(2);
					Date Data_Cadastro = result.getDate(3);
					String Nome_Tela = result.getString(4);
					String Imagem = result.getString(5);
					Boolean Situacao = result.getBoolean(6);
					Integer Tela_Pai = result.getInt(7);
					Integer Ordem = result.getInt(8);
					String Url_log = result.getString(9);
					Integer Versao_Origem= result.getInt(10);
					Tela tela = new Tela();
					
					tela.setId_tela(1);
					tela.setId_versao(2);
					tela.setData_Cadastro(Data_Cadastro);
					tela.setNome_Tela(Nome_Tela);
					tela.setImagem(Imagem);
					tela.setSituacao(Situacao);
					tela.setTela_Pai(Tela_Pai);
					tela.setOrdem(Ordem);
					tela.setUrl_log(Url_log);
					tela.setVersao_Origem(Versao_Origem);
			}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return telas;
	}
}

	
	
	
	
	
	
