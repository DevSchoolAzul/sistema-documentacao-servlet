package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.RequisicaoDao;
import br.com.sistemaDocumentacao.modelo.Requisicao;

public class Requisicoes implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String parametroIdEvento = request.getParameter("id_evento");
		

		try (Connection connection = new ConnectionFactory().getConnection()) {
			RequisicaoDao requisicaoDao = new RequisicaoDao(connection);			
			List<Requisicao> requisicoes = new ArrayList<>();
			if (parametroIdEvento == null || parametroIdEvento.isBlank()) {
				requisicoes = requisicaoDao.listarRequisicoes();
			} else {
				requisicoes = requisicaoDao.listarRequisicoesDoEvento(Integer.valueOf(parametroIdEvento));
			}
			request.setAttribute("requisicoes", requisicoes);				
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "forward:projetos/requisicoes.jsp";
	}

}
