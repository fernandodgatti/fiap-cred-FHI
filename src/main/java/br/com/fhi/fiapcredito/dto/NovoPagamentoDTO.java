package br.com.fhi.fiapcredito.dto;

public class NovoPagamentoDTO {

	private String idPagamento;
	private String numeroCartao;
	private int mesExpiracao;
	private int anoExpiracao;
	private int cvc;

	public String getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public int getMesExpiracao() {
		return mesExpiracao;
	}

	public void setMesExpiracao(int mesExpiracao) {
		this.mesExpiracao = mesExpiracao;
	}

	public int getAnoExpiracao() {
		return anoExpiracao;
	}

	public void setAnoExpiracao(int anoExpiracao) {
		this.anoExpiracao = anoExpiracao;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
}
