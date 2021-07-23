package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.VersaoDao;
import br.com.sistemaDocumentacao.modelo.Versao;

public class InserirVersao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdProjeto = request.getParameter("id_projeto");
		String parametroDataLancamento = request.getParameter("data_lancamento");
		String parametroGmud = request.getParameter("gmud");
		String parametroNumeroVersao = request.getParameter("numero_versao");
		//String parametroIdClone = request.getParameter("id_clone");
		String parametroSituacao = request.getParameter("situacao");
		String parametroDescricao = request.getParameter("descricao");
		
		Versao versao = new Versao();
		versao.setId_projeto(Integer.valueOf(parametroIdProjeto));
		versao.setData_lancamento(LocalDate.parse(parametroDataLancamento));
		versao.setGmud(parametroGmud);
		versao.setNumero_versao(parametroNumeroVersao);
		versao.setSituacao("1".equals(parametroSituacao));
		versao.setDescricao(parametroDescricao);
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			VersaoDao versaoDao = new VersaoDao(connection);
			versaoDao.cadastrar(versao);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		return "redirect:Versoes";
	}

}
