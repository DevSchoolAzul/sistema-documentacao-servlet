package br.com.sistemaDocumentacao.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.acao.Acao;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/entrada")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		Class<?> clase;
		String respostaAcao;
		try {
			clase = Class.forName("br.com.sistemaDocumentacao.acao." + paramAcao);
			Acao acao = (Acao) clase.getDeclaredConstructor().newInstance();
			respostaAcao = acao.executa(request, response);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		String[] tipo_recurso = respostaAcao.split(":");
		if (tipo_recurso[0].equals("forward")) {
			request.getRequestDispatcher("/WEB-INF/views/" + tipo_recurso[1]).forward(request, response);
		} else {
			response.sendRedirect("entrada?acao=" + tipo_recurso[1]);
		}
	}

}
