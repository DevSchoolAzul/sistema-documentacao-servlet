package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.RequisicaoDao;
import br.com.sistemaDocumentacao.modelo.Requisicao;

public class NovaPropriedade implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			RequisicaoDao requisicaoDao = new RequisicaoDao(connection);
			List<Requisicao> requisicoes = requisicaoDao.listarRequisicoes();
			request.setAttribute("requisicoes", requisicoes);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		
		return "forward:propriedades/nova-propriedade.jsp";
	}

}
