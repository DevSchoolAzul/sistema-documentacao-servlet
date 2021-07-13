package br.com.sistemaDocumentacao.modelo;

import java.time.LocalDate;

public class Versao {

	private int id_versao;
	private int id_projeto;
	private String gmud;
	private String descricao;
	private LocalDate data_lancamento;
	private boolean situacao;
	private int ordem;
	private String numero_versao;

	public int getId_versao() {
		return id_versao;
	}

	public void setId_versao(int id_versao) {
		this.id_versao = id_versao;
	}

	public int getId_projeto() {
		return id_projeto;
	}

	public void setId_projeto(int id_projeto) {
		this.id_projeto = id_projeto;
	}

	public String getGmud() {
		return gmud;
	}

	public void setGmud(String gmud) {
		this.gmud = gmud;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData_lancamento() {
		return data_lancamento;
	}

	public void setData_lancamento(LocalDate data_lancamento) {
		this.data_lancamento = data_lancamento;
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

	public String getNumero_versao() {
		return numero_versao;
	}

	public void setNumero_versao(String numero_versao) {
		this.numero_versao = numero_versao;
	}

}
