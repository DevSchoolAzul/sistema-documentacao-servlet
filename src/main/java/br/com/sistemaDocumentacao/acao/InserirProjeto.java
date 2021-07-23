package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.ProjetoDao;
import br.com.sistemaDocumentacao.modelo.Projeto;

public class InserirProjeto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		boolean situacao = request.getParameter("situacao").equals("1");
		Projeto projeto = new Projeto();
		projeto.setNome(nome);
		projeto.setSituacao(situacao);
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			ProjetoDao dao = new ProjetoDao(connection);
			dao.cadastrar(projeto);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:Projetos";
	}

}
