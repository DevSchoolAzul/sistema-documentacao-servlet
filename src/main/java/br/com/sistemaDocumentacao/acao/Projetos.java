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
import br.com.sistemaDocumentacao.modelo.Projeto;

public class Projetos implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = new ConnectionFactory().getConnection()) {
			ProjetoDao dao = new ProjetoDao(connection);			
			List<Projeto> projetos = dao.listarProjetos();
			request.setAttribute("projetos", projetos);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "forward:projetos/projetos.jsp";
	}

}
