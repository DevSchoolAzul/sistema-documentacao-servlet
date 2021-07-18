package br.com.sistemaDocumentacao.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaDocumentacao.modelo.Versao;

public class EditarVersao implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		int id = Integer.valueOf(request.getParameter("id_versao"));
		
		/* SIMULANDO A BUSCO NO BANCO PELA REQUISICAO INFORMADA */
		Versao versao = new Versao();
		versao.setId_versao(1);
		versao.setId_projeto(5);
		versao.setGmud("123456");
		versao.setDescricao("Versao 1 do facebook");
		versao.setData_lancamento(null);
		versao.setSituacao(true);
		versao.setOrdem(1);
		versao.setNumero_versao("1.0");
		
		request.setAttribute("versao", versao);
		return "forward:versoes/update-version.jsp";
	}

}
