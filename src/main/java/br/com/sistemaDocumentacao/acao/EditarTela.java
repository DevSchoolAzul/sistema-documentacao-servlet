package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.TelaDao;
import br.com.sistemaDocumentacao.modelo.Tela;

public class EditarTela implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdTela = request.getParameter("id_tela");
		Integer idTela = Integer.valueOf(parametroIdTela);
		
		
		try (Connection connection = new ConnectionFactory().getConnection()){
			TelaDao telaDao = new TelaDao(connection);
			Tela tela = telaDao.buscarPorId(idTela);
			request.setAttribute("tela", tela);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "forward:telas/update-screen.jsp";
	}

}
