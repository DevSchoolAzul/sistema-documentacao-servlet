package br.com.sistemaDocumentacao.modelo;

import java.time.LocalDate;

//(Id_tela,Id_versao,Data_Cadastro,Nome_Tela,Imagem,Situacao,Tela_Pai,Ordem,Url_log,Versao_Origem)
public class Tela {

	private int Id_tela;
	private int Id_versao;
	private LocalDate Data_Cadastro;
	private String Nome_Tela;
	private String Imagem;
	private boolean Situacao;
	private int Tela_Pai;
	private int Ordem;
	private String Url_log;
	private int Versao_Origem;

	// metodos get e set

	public int getId_tela() {
		return Id_tela;
	}

	public void setId_tela(int id_tela) {
		Id_tela = id_tela;
	}

	public int getId_versao() {
		return Id_versao;
	}

	public void setId_versao(int id_versao) {
		Id_versao = id_versao;
	}

	public String getNome_Tela() {
		return Nome_Tela;
	}

	public void setNome_Tela(String nome_Tela) {
		Nome_Tela = nome_Tela;
	}

	public String getImagem() {
		return Imagem;
	}

	public void setImagem(String imagem) {
		Imagem = imagem;
	}

	public boolean isSituacao() {
		return Situacao;
	}

	public void setSituacao(boolean situacao) {
		Situacao = situacao;
	}

	public int getTela_Pai() {
		return Tela_Pai;
	}

	public void setTela_Pai(int tela_Pai) {
		Tela_Pai = tela_Pai;
	}

	public int getOrdem() {
		return Ordem;
	}

	public void setOrdem(int ordem) {
		Ordem = ordem;
	}

	public String getUrl_log() {
		return Url_log;
	}

	public void setUrl_log(String url_log) {
		Url_log = url_log;
	}

	public int getVersao_Origem() {
		return Versao_Origem;
	}

	public void setVersao_Origem(int versao_Origem) {
		Versao_Origem = versao_Origem;
	}

	public void setData_Cadastro(LocalDate data_Cadastro) {
		Data_Cadastro = data_Cadastro;
	}

	public LocalDate getData_Cadastro() {
		return Data_Cadastro;
	}

}
