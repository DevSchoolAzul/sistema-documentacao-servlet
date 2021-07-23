package br.com.sistemaDocumentacao.modelo;

public class Propriedade {

	private Integer idPropriedade;
	private Integer idRequisicao;
	private String chave;
	private String valor;
	private Integer ordem;

	public Integer getIdPropriedade() {
		return idPropriedade;
	}

	public void setIdPropriedade(Integer idPropriedade) {
		this.idPropriedade = idPropriedade;
	}

	public Integer getIdRequisicao() {
		return idRequisicao;
	}

	public void setIdRequisicao(Integer idRequisicao) {
		this.idRequisicao = idRequisicao;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

}
