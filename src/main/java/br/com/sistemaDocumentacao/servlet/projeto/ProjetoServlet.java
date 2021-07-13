package br.com.sistemaDocumentacao.servlet.projeto;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.ProjetoDao;
import br.com.sistemaDocumentacao.modelo.Projeto;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/projeto")
public class ProjetoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = ConnectionFactory.getConnection();
		ProjetoDao dao = new ProjetoDao(connection);
		
		List<Projeto> projetos = dao.listarProjetos();
		
		request.setAttribute("projetos", projetos);
		
		request.getRequestDispatcher("WEB-INF/views/projeto/projetos.jsp").forward(request, response);
	}

}
