package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.ProjetoDao;
import br.com.sistemaDocumentacao.dao.TelaDao;
import br.com.sistemaDocumentacao.dao.VersaoDao;
import br.com.sistemaDocumentacao.modelo.Projeto;
import br.com.sistemaDocumentacao.modelo.Tela;
import br.com.sistemaDocumentacao.modelo.Versao;

public class Telas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdProjeto = request.getParameter("id_projeto");
		String parametroIdVersao = request.getParameter("id_versao");
		String parametroSituacao = request.getParameter("situacao");
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			ProjetoDao projetoDao = new ProjetoDao(connection);
			List<Projeto> projetos = projetoDao.listarProjetos();
			request.setAttribute("projetos", projetos);

			if (parametroIdProjeto != null && parametroIdProjeto != "0") {
				Integer idProjeto = Integer.valueOf(parametroIdProjeto);
				VersaoDao versaoDao = new VersaoDao(connection);
				List<Versao> versoes = versaoDao.listarVersoesDoProjeto(idProjeto);
				request.setAttribute("versoes", versoes);
			}
			
			if (parametroIdVersao != null && parametroIdVersao != "0") {
				TelaDao telaDao = new TelaDao(connection);
				// TODO alterar listarTela para listarTelas (no plural)
				Integer idVersao = Integer.valueOf(parametroIdVersao);
				List<Tela> telas;
				if (parametroSituacao == null || parametroSituacao.equals("0")) {
					telas = telaDao.listarTelaDeUmaVersao(idVersao);
					request.setAttribute("telas", telas);					
				} else {
					boolean situacao = "1".equals(parametroSituacao);
					telas = telaDao.listarTelaDeUmaVersaoComSituacao(idVersao, situacao);
				}
				request.setAttribute("telas", telas);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		request.setAttribute("id_projeto", parametroIdProjeto);
		request.setAttribute("id_versao", parametroIdVersao);
		request.setAttribute("parametroSituacao", parametroSituacao);
		return "forward:telas/telas.jsp";
	}

}
