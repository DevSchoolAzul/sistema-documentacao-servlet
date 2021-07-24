package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.TipoEventoDao;
import br.com.sistemaDocumentacao.modelo.TipoEvento;

public class TiposEventos implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			TipoEventoDao tipoDao = new TipoEventoDao(connection);
			List<TipoEvento> tiposEventos = tipoDao.listarTipoEventos();
			request.setAttribute("tiposEventos", tiposEventos);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "forward:tiposEventos/tiposEventos.jsp";
	}

}
