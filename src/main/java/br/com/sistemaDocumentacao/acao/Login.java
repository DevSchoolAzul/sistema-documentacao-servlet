package br.com.sistemaDocumentacao.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.UsuarioDao;
import br.com.sistemaDocumentacao.modelo.Usuario;


public class Login implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	String parametroEmail = request.getParameter("email");
		String parametroSenha = request.getParameter("senha");
		
		Usuario usuario = null;		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			UsuarioDao usuarioDao = new UsuarioDao(connection);
			usuario = usuarioDao.usuarioExiste(parametroEmail, parametroSenha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		if (usuario != null) {
			System.out.println("Usuario " + usuario.getNome() + " existe");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:Projetos";
		} else {
			return "redirect:LoginForm";
		}	
    }
    
}
