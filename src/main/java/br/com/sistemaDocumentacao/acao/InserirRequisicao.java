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

public class InserirRequisicao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdEvento = request.getParameter("id_evento");
		String parametroUrlHomolog = request.getParameter("url_homolog");
		String parametroUriProd = request.getParameter("uri_prod");
		String parametroDescricao = request.getParameter("descricao");
		String parametroRequisicaoPai = request.getParameter("requisicao_pai");
		String parametroCamada = request.getParameter("camada");
		String parametroSituacao = request.getParameter("situacao");
		String parametroOrdem = request.getParameter("ordem");
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			RequisicaoDao requisicaoDao = new RequisicaoDao(connection);
			Requisicao requisicao = new Requisicao();
			requisicao.setId_evento(Integer.parseInt(parametroIdEvento));
			requisicao.setUrl_homolog(parametroUrlHomolog);
			requisicao.setUri_prod(parametroUriProd);
			requisicao.setDescricao(parametroDescricao);
			if ("0".equals(parametroRequisicaoPai)) {
				requisicao.setRequisicao_pai(null);
			} else {
				requisicao.setRequisicao_pai(Integer.parseInt(parametroRequisicaoPai));				
			}
			requisicao.setCamada(parametroCamada);
			requisicao.setSituacao("1".equals(parametroSituacao));
			requisicao.setOrdem(Integer.parseInt(parametroOrdem));
			requisicaoDao.cadastrar(requisicao);
		} catch(SQLException e) {
			throw new RuntimeException();
		}
		return "redirect:Requisicoes";
	}

}
