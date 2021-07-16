package br.com.sistemaDocumentacao.modelo;

public class Evento {

	private int id_evento;
	private int id_tipo_evento;
	private int id_tela;
	private boolean situacao;
	private int ordem;
	private String parametros;

	public int getId_evento() {
		return id_evento;
	}

	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}

	public int getId_tipo_evento() {
		return id_tipo_evento;
	}

	public void setId_tipo_evento(int id_tipo_evento) {
		this.id_tipo_evento = id_tipo_evento;
	}

	public int getId_tela() {
		return id_tela;
	}

	public void setId_tela(int id_tela) {
		this.id_tela = id_tela;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public String getParametros() {
		return parametros;
	}

	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	@Override
	public String toString() {
		return "Evento [id_evento=" + id_evento + ", id_tipo_evento=" + id_tipo_evento + ", id_tela=" + id_tela
				+ ", situacao=" + situacao + ", ordem=" + ordem + ", parametros=" + parametros + "]";
	}

}
