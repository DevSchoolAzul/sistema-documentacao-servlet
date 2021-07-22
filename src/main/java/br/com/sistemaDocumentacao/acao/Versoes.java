package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.ProjetoDao;
import br.com.sistemaDocumentacao.dao.VersaoDao;
import br.com.sistemaDocumentacao.modelo.Projeto;
import br.com.sistemaDocumentacao.modelo.Versao;

public class Versoes implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String parametroIdProjeto = request.getParameter("id_projeto");
		String parametroSituacao = request.getParameter("situacao");
		
		List<Versao> versoes = new ArrayList<>();
		List<Projeto> projetos;
		try (Connection connection = new ConnectionFactory().getConnection()) {
			ProjetoDao projetoDao = new ProjetoDao(connection);
			VersaoDao dao = new VersaoDao(connection);
			projetos = projetoDao.listarProjetos();
			if (parametroIdProjeto != null) {
				Integer idProjeto = Integer.valueOf(parametroIdProjeto);
				boolean situacao = "1".equals(parametroSituacao);
				if (parametroSituacao == null || Integer.valueOf(parametroSituacao) == 0) {
					versoes = dao.listarVersoesDoProjeto(idProjeto);
				} else {
					versoes = dao.listarVersoesDoProjetoComSituacao(idProjeto, situacao);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		request.setAttribute("id_projeto", parametroIdProjeto);
		request.setAttribute("parametroSituacao", parametroSituacao);
		request.setAttribute("projetos", projetos);
		request.setAttribute("versoes", versoes);
		return "forward:versoes/versoes.jsp";
	}

}
