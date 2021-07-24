package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.TipoEventoDao;
import br.com.sistemaDocumentacao.modelo.TipoEvento;

public class AlterarTipoEvento implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String situaco = request.getParameter("situacao");
		Integer id = Integer.valueOf(request.getParameter("id_tipo_evento"));
		
		try (Connection connection = new ConnectionFactory().getConnection()){
			TipoEventoDao dao = new TipoEventoDao(connection);
			TipoEvento tipo = dao.buscarPorId(id);
			tipo.setNome(nome);
			tipo.setSituacao("1".equals(situaco));
			dao.atualizar(tipo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:TiposEventos";
	}
}
