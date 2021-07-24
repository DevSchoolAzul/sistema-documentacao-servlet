package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.EventoDao;
import br.com.sistemaDocumentacao.dao.TelaDao;
import br.com.sistemaDocumentacao.dao.TipoEventoDao;
import br.com.sistemaDocumentacao.modelo.Evento;
import br.com.sistemaDocumentacao.modelo.Tela;
import br.com.sistemaDocumentacao.modelo.TipoEvento;

public class EditarEvento implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer paramatroIdEvento = Integer.valueOf(request.getParameter("id_evento"));
		
		try (Connection connection = new ConnectionFactory().getConnection()){
			EventoDao eventoDao = new EventoDao(connection);
			TelaDao telaDao = new TelaDao(connection);
			TipoEventoDao tipoEventoDao = new TipoEventoDao(connection);
			Evento evento = eventoDao.buscarPorId(paramatroIdEvento);
			List<Tela> telas = telaDao.listarTelas();
			List<TipoEvento> tiposEventos = tipoEventoDao.listarTipoEventos();
			request.setAttribute("evento", evento);
			request.setAttribute("telas", telas);
			request.setAttribute("tiposEventos", tiposEventos);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "forward:eventos/alterar-evento.jsp";
	}

}
