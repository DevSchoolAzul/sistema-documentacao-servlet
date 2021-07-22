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
import br.com.sistemaDocumentacao.dao.ProjetoDao;
import br.com.sistemaDocumentacao.modelo.Projeto;

public class Projetos implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String parametroNomeProjeto = request.getParameter("nomeProjeto");
		String parametroSituacao = request.getParameter("situacao");
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			ProjetoDao dao = new ProjetoDao(connection);			
			List<Projeto> projetos = new ArrayList<>();
			if (parametroNomeProjeto == null || parametroNomeProjeto.isBlank()) {
				if (parametroSituacao == null || "0".equals(parametroSituacao)) {
					projetos = dao.listarProjetos();					
				} else {
					projetos = dao.listarPorSituacao("1".equals(parametroSituacao));
				}
			} else {
				if (parametroSituacao == null || parametroSituacao.equals("0")) {
					projetos = dao.buscarPorNome(parametroNomeProjeto);					
				} else {
					boolean situacao = "1".equals(parametroSituacao);
					projetos = dao.buscarPorNomeESituacao(parametroNomeProjeto, situacao);
				}
			}
			request.setAttribute("projetos", projetos);				
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		request.setAttribute("nomeProjeto", parametroNomeProjeto);
		request.setAttribute("parametroSituacao", parametroSituacao);
		return "forward:projetos/projetos.jsp";
	}

}
