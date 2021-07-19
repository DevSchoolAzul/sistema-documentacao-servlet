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

public class AlterarVersao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idVersao = Integer.valueOf(request.getParameter("id_versao"));
		String numeroVersao = request.getParameter("numero_versao");
		LocalDate dataLancamento = LocalDate.parse(request.getParameter("data_lancamento"));
		Boolean situacao = request.getParameter("situacao").equals("1");
		String descricao = request.getParameter("descricao");
		String gmud = request.getParameter("gmud");
		
		Integer idProjeto;
		try (Connection connection = new ConnectionFactory().getConnection()) {
			VersaoDao versaoDao = new VersaoDao(connection);
			Versao versao = versaoDao.buscarPorId(idVersao);
			versao.setNumero_versao(numeroVersao);
			versao.setData_lancamento(dataLancamento);
			versao.setSituacao(situacao);
			versao.setDescricao(descricao);
			versao.setGmud(gmud);
			versaoDao.atualizar(versao);
			idProjeto = versao.getId_projeto();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		return "redirect:Versoes&id_projeto=" + idProjeto;
	}

}
