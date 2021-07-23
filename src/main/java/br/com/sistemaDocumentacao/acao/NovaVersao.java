package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.ProjetoDao;
import br.com.sistemaDocumentacao.dao.VersaoDao;
import br.com.sistemaDocumentacao.modelo.Projeto;
import br.com.sistemaDocumentacao.modelo.Versao;

public class NovaVersao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Integer id_projeto = Integer.valueOf(request.getParameter("id_projeto"));
		try (Connection connection = new ConnectionFactory().getConnection()) {
			ProjetoDao projetoDao = new ProjetoDao(connection);
			VersaoDao versaoDao = new VersaoDao(connection);
			
//			Projeto projeto = projetoDao.buscarPorId(id_projeto);
			List<Projeto> projetos = projetoDao.listarProjetos();
			List<Versao> versoes = versaoDao.listarVersoes();
			
//			request.setAttribute("projeto", projeto);
			request.setAttribute("projetos", projetos);
			request.setAttribute("versoes", versoes);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "forward:versoes/new-version.jsp";
	}

}
