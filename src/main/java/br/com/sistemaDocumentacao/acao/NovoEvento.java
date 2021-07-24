package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.TelaDao;
import br.com.sistemaDocumentacao.dao.TipoEventoDao;
import br.com.sistemaDocumentacao.modelo.Tela;
import br.com.sistemaDocumentacao.modelo.TipoEvento;

public class NovoEvento implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = new ConnectionFactory().getConnection()){
			TelaDao telaDao = new TelaDao(connection);
			TipoEventoDao tipoEventoDao = new TipoEventoDao(connection);
			List<Tela> telas = telaDao.listarTelas();
			List<TipoEvento> tipoEventos = tipoEventoDao.listarTipoEventos();
			request.setAttribute("telas", telas);
			request.setAttribute("tipoEventos", tipoEventos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "forward:eventos/new-event.jsp";
	}

}
