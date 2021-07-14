package br.com.sistemaDocumetacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.ProjetoDao;
import br.com.sistemaDocumentacao.modelo.Projeto;

public class Projetos implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = ConnectionFactory.getConnection();
		ProjetoDao dao = new ProjetoDao(connection);
		
		List<Projeto> projetos = dao.listarProjetos();
		
		request.setAttribute("projetos", projetos);
		
		return "forward:WEB-INF/views/projeto/projetos.jsp";
	}

}
