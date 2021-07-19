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
import br.com.sistemaDocumentacao.modelo.Tela;

public class Telas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id_versao = Integer.valueOf(request.getParameter("id_versao"));
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			TelaDao telaDao = new TelaDao(connection);
			// TODO alterar listarTela para listarTelas (no plural)
			List<Tela> telas = telaDao.listarTelaDeUmaVersao(id_versao);
			
			request.setAttribute("telas", telas);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "forward:telas/telas.jsp";
	}

}
