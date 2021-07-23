package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.PropriedadeDao;
import br.com.sistemaDocumentacao.modelo.Propriedade;

public class Propriedades implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			PropriedadeDao propriedadeDao = new PropriedadeDao(connection);
			List<Propriedade> propriedades = propriedadeDao.ListarPropriedades();
			request.setAttribute("propriedades", propriedades);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "forward:propriedades/propriedades.jsp";
	}

}
