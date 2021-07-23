package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.PropriedadeDao;
import br.com.sistemaDocumentacao.modelo.Propriedade;

public class AlterarPropriedade implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idPropriedade = Integer.valueOf(request.getParameter("id_propriedade"));
		String parametroChave = request.getParameter("chave");
		String parametroValor = request.getParameter("valor");
		Integer ordem = Integer.valueOf(request.getParameter("ordem"));

		try (Connection connection = new ConnectionFactory().getConnection()) {
			PropriedadeDao propriedadeDao = new PropriedadeDao(connection);
			Propriedade propriedade = propriedadeDao.buscarPorId(idPropriedade);
			propriedade.setChave(parametroChave);
			propriedade.setValor(parametroValor);
			propriedade.setOrdem(ordem);
			
			propriedadeDao.atualizar(propriedade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:Propriedades";
	}

}
