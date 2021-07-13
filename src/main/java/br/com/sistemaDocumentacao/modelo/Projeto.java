package br.com.sistemaDocumentacao.modelo;

public class Projeto {

	private int id_projeto;
	private String nome;
	private boolean situacao;

	public int getId_projeto() {
		return id_projeto;
	}

	public void setId_projeto(int id_projeto) {
		this.id_projeto = id_projeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

}