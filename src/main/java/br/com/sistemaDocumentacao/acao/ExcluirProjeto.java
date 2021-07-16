package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.ProjetoDao;

public class ExcluirProjeto implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id_projeto"));
		
		Connection connection = new ConnectionFactory().getConnection();
		ProjetoDao dao = new ProjetoDao(connection);
		dao.excluir(id);
		
		return "redirect:Projetos";
	}

}
