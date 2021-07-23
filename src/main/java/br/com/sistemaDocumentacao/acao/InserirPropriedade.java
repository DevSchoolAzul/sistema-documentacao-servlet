package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.PropriedadeDao;
import br.com.sistemaDocumentacao.dao.VersaoDao;
import br.com.sistemaDocumentacao.modelo.Propriedade;

public class InserirPropriedade implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idRequisicao = Integer.valueOf(request.getParameter("idRequisicao"));
		String chave = request.getParameter("chave");
		String valor = request.getParameter("valor");
		Integer ordem = Integer.valueOf(request.getParameter("ordem"));
		
		Propriedade propriedade = new Propriedade();
		propriedade.setIdRequisicao(idRequisicao);
		propriedade.setChave(chave);
		propriedade.setValor(valor);
		propriedade.setOrdem(ordem);
		
		try (Connection connection = new ConnectionFactory().getConnection()){
			PropriedadeDao propriedadeDao = new PropriedadeDao(connection);
			propriedadeDao.cadastrar(propriedade);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "redirect:Propriedades";
	}

}
