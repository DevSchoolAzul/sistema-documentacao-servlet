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

public class InserirTela implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroNomeTela = request.getParameter("nomeTela");
		String parametroTelaPai = request.getParameter("telaPai");
		String parametroDataLancamento = request.getParameter("dataLancamento");
		String parametroIdVersao = request.getParameter("idVersao");
		String parametroSituacao = request.getParameter("situacao");
		String parametroOrdem = request.getParameter("ordem");
		String parametroUrlLog = request.getParameter("urlLog");
		String parametroImagem = request.getParameter("imagem");
		
		Tela tela = new Tela();
		tela.setNomeTela(parametroNomeTela);
		if (parametroTelaPai != null && !parametroTelaPai.isEmpty()) {
			tela.setTelaPai(Integer.valueOf(parametroTelaPai));
		}
		tela.setDataCadastro(LocalDate.parse(parametroDataLancamento));
		tela.setIdVersao(Integer.valueOf(parametroIdVersao));
		tela.setVersaoOrigem(Integer.valueOf(parametroIdVersao));
		tela.setSituacao("1".equals(parametroSituacao));
		tela.setOrdem(Integer.valueOf(parametroOrdem));
		tela.setUrlLog(parametroUrlLog);
		tela.setImagem(parametroImagem);
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			TelaDao telaDao = new TelaDao(connection);
			telaDao.cadastrar(tela);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:Telas";
	}
}
