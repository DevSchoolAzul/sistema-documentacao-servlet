package br.com.sistemaDocumetacao.acao;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.ProjetoDao;
import br.com.sistemaDocumentacao.modelo.Projeto;

public class AlterarProjeto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id_projeto"));
		String nome = request.getParameter("nome");
		boolean situacao = request.getParameter("situacao").equals("1");
		Projeto projeto = new Projeto();
		projeto.setId_projeto(id);
		projeto.setNome(nome);
		projeto.setSituacao(situacao);
		
		Connection connection = new ConnectionFactory().getConnection();
		ProjetoDao dao = new ProjetoDao(connection);
		dao.atualizar(projeto);
		
		return "redirect:Projetos";
	}

}
