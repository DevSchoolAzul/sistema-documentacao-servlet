package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.VersaoDao;

public class ExcluirVersao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idVersao = Integer.valueOf(request.getParameter("id_versao"));
		
		try (Connection connection = new ConnectionFactory().getConnection()){
			VersaoDao versaoDao = new VersaoDao(connection);
			versaoDao.excluir(idVersao);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "redirect:Versoes";
	}
}
