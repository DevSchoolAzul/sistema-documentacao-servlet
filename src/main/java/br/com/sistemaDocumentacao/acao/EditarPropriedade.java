package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.PropriedadeDao;
import br.com.sistemaDocumentacao.modelo.Propriedade;

public class EditarPropriedade implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idPropriedade = Integer.valueOf(request.getParameter("id_propriedade")); 
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			PropriedadeDao propriedadeDao = new PropriedadeDao(connection);
			Propriedade propriedade = propriedadeDao.buscarPorId(idPropriedade);
			request.setAttribute("propriedade", propriedade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "forward:propriedades/alterar-propriedade.jsp";
	}

}
