package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.TelaDao;
import br.com.sistemaDocumentacao.modelo.Tela;

public class AlterarTela implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdTela = request.getParameter("id_tela");
		Integer idTela = Integer.valueOf(parametroIdTela);
		String parametroNome = request.getParameter("nome");
		String parametroTelaPai = request.getParameter("telaPai");
		String parametroDataCadastro = request.getParameter("dataCadastro");
		String parametroSituacao = request.getParameter("situacao");
		String parametroOrdem = request.getParameter("ordem");
		String parametroUrlLog = request.getParameter("urlLog");
		String parametroImagem = request.getParameter("imagem");
		
		try (Connection connection = new ConnectionFactory().getConnection()){
			TelaDao telaDao = new TelaDao(connection);
			Tela tela = telaDao.buscarPorId(idTela);
			tela.setNomeTela(parametroNome);
			tela.setTelaPai(Integer.valueOf(parametroTelaPai));
			tela.setDataCadastro(LocalDate.parse(parametroDataCadastro));
			tela.setSituacao("1".equals(parametroSituacao));
			tela.setOrdem(Integer.valueOf(parametroOrdem));
			tela.setUrlLog(parametroUrlLog);
			tela.setImagem(parametroImagem);
			
			telaDao.atualizar(tela);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "redirect:Telas";
	}

}
