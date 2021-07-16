package classeParaTestarSuaDao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.EventoDao;
import br.com.sistemaDocumentacao.modelo.Evento;

public class TestaDao {

	public static void main(String[] args) {
		try (Connection c = new ConnectionFactory().getConnection()) {
			EventoDao dao = new EventoDao(c);
			Evento evento;
			
			/* CADASTRAR */
//			evento1 = new Evento();
//			evento1.setId_tela(1);
//			evento1.setId_tipo_evento(1);
//			evento1.setOrdem(1);
//			evento1.setParametros("email, senha");
//			evento1.setSituacao(true);
//			dao.cadastrar(evento1);
			
			/* CONSULTAR */
//			evento = dao.buscar(1);
//			System.out.println(evento);
			
			/* ATUALIZAR */
//			evento = dao.buscar(1);
//			evento.setSituacao(false);
//			dao.atualizar(evento);
//			
//			System.out.println(dao.buscar(1));
			
			/* EXCLUIR */
//			dao.cadastrar(dao.buscar(1));
			System.out.println(dao.buscar(1));
			System.out.println(dao.buscar(2));
			
//			dao.excluir(1);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
