package br.com.sistemaDocumetacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.VersaoDao;
import br.com.sistemaDocumentacao.modelo.Versao;

public class Versoes implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
int id_projeto = Integer.valueOf(request.getParameter("id_projeto"));
		
		Connection connection = new ConnectionFactory().getConnection();
		VersaoDao dao = new VersaoDao(connection);
		List<Versao> versoes = dao.listarVersoesDoProjeto(id_projeto);
		
		request.setAttribute("versoes", versoes);
		
		return "forward:versoes/versoes.jsp"; 
	}

}
