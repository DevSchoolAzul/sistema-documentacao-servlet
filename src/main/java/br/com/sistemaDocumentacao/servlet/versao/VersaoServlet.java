package br.com.sistemaDocumentacao.servlet.versao;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.VersaoDao;
import br.com.sistemaDocumentacao.modelo.Versao;

/**
 * Servlet implementation class VersaoServlet
 */
@WebServlet("/versoes")
public class VersaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_projeto = Integer.valueOf(request.getParameter("id_projeto"));
		
		Connection connection = ConnectionFactory.getConnection();
		VersaoDao dao = new VersaoDao(connection);
		List<Versao> versoes = dao.listarVersoesDoProjeto(id_projeto);
		
		request.setAttribute("versoes", versoes);
		request.getRequestDispatcher("WEB-INF/views/versao/versoes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
