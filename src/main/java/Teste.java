import java.sql.Connection;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.VersaoDao;

public class Teste {

	public static void main(String[] args) {
		Connection c = ConnectionFactory.getConnection();
		
		VersaoDao dao = new VersaoDao(c);
		

	}

}
