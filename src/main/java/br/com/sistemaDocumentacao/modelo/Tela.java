package br.com.sistemaDocumentacao.modelo;

import java.time.LocalDate;

//(Id_tela,Id_versao,Data_Cadastro,Nome_Tela,Imagem,Situacao,Tela_Pai,Ordem,Url_log,Versao_Origem)
public class Tela {

	private int idTela;
	private int idVersao;
	private LocalDate dataCadastro;
	private String nomeTela;
	private String imagem;
	private boolean situacao;
	private int telaPai;
	private int ordem;
	private String urlLog;
	private int versaoOrigem;

	public int getIdTela() {
		return idTela;
	}

	public void setIdTela(int idTela) {
		this.idTela = idTela;
	}

	public int getIdVersao() {
		return idVersao;
	}

	public void setIdVersao(int idVersao) {
		this.idVersao = idVersao;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNomeTela() {
		return nomeTela;
	}

	public void setNomeTela(String nomeTela) {
		this.nomeTela = nomeTela;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public int getTelaPai() {
		return telaPai;
	}

	public void setTelaPai(int telaPai) {
		this.telaPai = telaPai;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public String getUrlLog() {
		return urlLog;
	}

	public void setUrlLog(String urlLog) {
		this.urlLog = urlLog;
	}

	public int getVersaoOrigem() {
		return versaoOrigem;
	}

	public void setVersaoOrigem(int versaoOrigem) {
		this.versaoOrigem = versaoOrigem;
	}

}
