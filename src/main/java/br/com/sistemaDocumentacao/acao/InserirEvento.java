package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.EventoDao;
import br.com.sistemaDocumentacao.modelo.Evento;

public class InserirEvento implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdTela = request.getParameter("id_tela");
		String parametroIdTipoEvento = request.getParameter("id_tipo_evento");
		String parametroSituacao = request.getParameter("situacao");
		String parametroOrdem = request.getParameter("ordem");
		String parametroParametros = request.getParameter("parametros");
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			EventoDao eventoDao = new EventoDao(connection);
			Evento evento = new Evento();
			evento.setId_tela(Integer.parseInt(parametroIdTela));
			evento.setId_tipo_evento(Integer.parseInt(parametroIdTipoEvento));
			evento.setSituacao("1".equals(parametroSituacao));
			evento.setOrdem(Integer.parseInt(parametroOrdem));
			evento.setParametros(parametroParametros);
			eventoDao.cadastrar(evento);
		} catch(SQLException e) {
			throw new RuntimeException();
		}
		return "redirect:Eventos";
	}

}
