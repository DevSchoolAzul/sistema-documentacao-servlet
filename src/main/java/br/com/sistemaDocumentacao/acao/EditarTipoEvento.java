package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.TipoEventoDao;
import br.com.sistemaDocumentacao.modelo.TipoEvento;

public class EditarTipoEvento implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id_tipo_evento"));
		request.setAttribute("id_tipo_evento", id);
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			TipoEventoDao dao = new TipoEventoDao(connection);
			TipoEvento tipo = dao.buscarPorId(id);
			
			request.setAttribute("tipo", tipo);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:tiposEventos/alterar-tipo-evento.jsp";
	}

}
