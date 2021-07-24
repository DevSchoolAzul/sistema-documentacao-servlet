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
import br.com.sistemaDocumentacao.dao.RequisicaoDao;
import br.com.sistemaDocumentacao.modelo.Evento;
import br.com.sistemaDocumentacao.modelo.Requisicao;

public class NovaRequisicao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = new ConnectionFactory().getConnection()){
			EventoDao eventoDao = new EventoDao(connection);
			RequisicaoDao requisicaoDao = new RequisicaoDao(connection);
			List<Evento> eventos = eventoDao.listarEventos();
			List<Requisicao> requisicoes = requisicaoDao.listarRequisicoes();
			request.setAttribute("eventos", eventos);
			request.setAttribute("requisicoesPai", requisicoes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "forward:requisicoes/new-requisition.jsp";
	}

}
