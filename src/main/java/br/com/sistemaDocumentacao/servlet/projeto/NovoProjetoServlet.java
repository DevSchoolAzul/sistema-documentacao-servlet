package br.com.sistemaDocumentacao.servlet.projeto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.ProjetoDao;
import br.com.sistemaDocumentacao.modelo.Projeto;

/**
 * Servlet implementation class NovoProjetoServlet
 */
@WebServlet("/NovoProjeto")
public class NovoProjetoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/projeto/new-project.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		boolean situacao = request.getParameter("situacao").equals("1");
		Projeto projeto = new Projeto();
		projeto.setNome(nome);
		projeto.setSituacao(situacao);
		
		ProjetoDao dao = new ProjetoDao(ConnectionFactory.getConnection());
		dao.cadastrar(projeto);
		response.sendRedirect("projeto");
	}

}
