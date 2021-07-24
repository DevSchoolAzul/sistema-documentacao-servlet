package br.com.sistemaDocumentacao.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.acao.Acao;

public class ControllerServlet implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
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
