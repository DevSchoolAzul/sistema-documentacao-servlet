package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.TelaDao;

public class ExcluirTela implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdTela = request.getParameter("id_tela");
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			TelaDao telaDao = new TelaDao(connection);
			telaDao.excluir(Integer.valueOf(parametroIdTela));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "redirect:Telas";
	}

}
