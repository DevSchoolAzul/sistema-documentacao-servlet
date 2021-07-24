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

public class InserirTipoEvento implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String situacao = request.getParameter("situacao");
		
		TipoEvento tipo = new TipoEvento();
		tipo.setNome(nome);
		tipo.setSituacao("1".equals(situacao));
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			TipoEventoDao tipoDao = new TipoEventoDao(connection);
			tipoDao.cadastrar(tipo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:tiposEventos";
	}

}
