package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.RequisicaoDao;
import br.com.sistemaDocumentacao.modelo.Requisicao;

public class EditarRequisicao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdRequisicao = request.getParameter("id_requisicao");
		Integer idRequisicao = Integer.valueOf(parametroIdRequisicao);
		
		
		try (Connection connection = new ConnectionFactory().getConnection()){
			RequisicaoDao requisicaoDao = new RequisicaoDao(connection);
			Requisicao requisicao = requisicaoDao.buscarPorId(idRequisicao);
			request.setAttribute("requisicao", requisicao);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "forward:telas/update-requisition.jsp";
	}

}
