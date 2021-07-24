package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.TipoEventoDao;

public class ExcluirTipoEvento implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id_tipo_evento");
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			TipoEventoDao dao = new TipoEventoDao(connection);
			dao.excluir(Integer.valueOf(id));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "redirect:TiposEventos";
	}

}
