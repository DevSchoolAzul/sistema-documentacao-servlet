package br.com.sistemaDocumetacao.acao;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.ProjetoDao;
import br.com.sistemaDocumentacao.modelo.Projeto;

public class EditarProjeto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id_projeto"));
		
		Connection connection = ConnectionFactory.getConnection();
		ProjetoDao dao = new ProjetoDao(connection);
		Projeto projeto = dao.buscarPorId(id);
		
		request.setAttribute("projeto", projeto);
		return "forward:projetos/update-project.jsp";
	}

}
