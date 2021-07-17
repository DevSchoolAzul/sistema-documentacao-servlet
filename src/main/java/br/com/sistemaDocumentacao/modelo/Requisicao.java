package br.com.sistemaDocumentacao.modelo;

public class Requisicao {
	
	private Integer id_requisicao;
	private Integer id_evento;
	private String url_homolog;
	private String uri_prod;
	private String descricao;
	private Integer requisicao_pai;
	private String camada;
	private boolean situacao;
	private Integer ordem;
	
	public Integer getId_requisicao() {
		return id_requisicao;
	}
	public void setId_requisicao(Integer id_requisicao) {
		this.id_requisicao = id_requisicao;
	}
	public Integer getId_evento() {
		return id_evento;
	}
	public void setId_evento(Integer id_evento) {
		this.id_evento = id_evento;
	}
	public String getUrl_homolog() {
		return url_homolog;
	}
	public void setUrl_homolog(String url_homolog) {
		this.url_homolog = url_homolog;
	}
	public String getUri_prod() {
		return uri_prod;
	}
	public void setUri_prod(String uri_prod) {
		this.uri_prod = uri_prod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getRequisicao_pai() {
		return requisicao_pai;
	}
	public void setRequisicao_pai(Integer requisicao_pai) {
		this.requisicao_pai = requisicao_pai;
	}
	public String getCamada() {
		return camada;
	}
	public void setCamada(String camada) {
		this.camada = camada;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}	
}
