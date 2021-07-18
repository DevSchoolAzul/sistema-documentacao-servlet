package testaClasses;

import java.sql.Connection;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import br.com.sistemaDocumentacao.connection.ConnectionFactory;
import br.com.sistemaDocumentacao.dao.TelaDao;
import br.com.sistemaDocumentacao.modelo.Tela;

public class Teste {
	public static void main(String[] args) {

		Connection connection = new ConnectionFactory().getConnection();
		TelaDao dao = new TelaDao(connection);
		
		Tela tela = dao.buscarPorId(3);
		
		dao.excluir(3);
		System.out.println("foi");
//		tela.setId_versao(1);
//		tela.setData_Cadastro(LocalDate.now() );
//		tela.setNome_Tela("Tela de cadastra no java");
//		tela.setImagem("http://imagem-de-cafe.com");
//		tela.setSituacao(true);
////		tela.setTela_Pai();
//		tela.setOrdem(1);
//		tela.setUrl_log("http://urllog");
//		tela.setVersao_Origem(1);
//		
//		
//		dao.cadastrar(tela);
		
	}
}
