package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.PropriedadeDao;

public class ExcluirPropriedade implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdPropriedade = request.getParameter("id_propriedade");
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			PropriedadeDao propriedadeDao = new PropriedadeDao(connection);
			propriedadeDao.excluir(Integer.valueOf(parametroIdPropriedade));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "redirect:Propriedades";
	}

}
