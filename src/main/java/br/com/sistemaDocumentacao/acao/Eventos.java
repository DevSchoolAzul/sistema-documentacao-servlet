package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.EventoDao;
import br.com.sistemaDocumentacao.modelo.Evento;

public class Eventos implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String parametroIdTela = request.getParameter("id_tela");
		

		try (Connection connection = new ConnectionFactory().getConnection()) {
			EventoDao eventoDao = new EventoDao(connection);			
			List<Evento> eventos = new ArrayList<>();
			if (parametroIdTela == null || parametroIdTela.isBlank()) {
				eventos = eventoDao.listarEventos();
			} else {
				eventos = eventoDao.listarEventosDaTela(Integer.valueOf(parametroIdTela));
			}
			request.setAttribute("eventos", eventos);				
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "forward:projetos/requisicoes.jsp";
	}

}
