package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.EventoDao;

public class ExcluirEvento implements Acao{
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer paramatroIdEvento = Integer.valueOf(request.getParameter("id_evento"));
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			EventoDao eventoDao = new EventoDao(connection);
			eventoDao.excluir(paramatroIdEvento);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "redirect:Eventos";
	}

}
