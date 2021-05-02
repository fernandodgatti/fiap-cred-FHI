package br.com.fhi.fiapcredito.dto;

import br.com.fhi.fiapcredito.entity.Aluno;

public class AlunoDTO {
	
	private String registroAluno;
	private String nomeAluno;
	private String codigoCartao;
	private String idMoip;
	
	public AlunoDTO() {
		
	}
	public AlunoDTO(Aluno aluno) {
		this.registroAluno = aluno.getRegistroAluno();
		this.nomeAluno = aluno.getNomeAluno();
		this.codigoCartao = aluno.getCodigoCartao();
		this.idMoip = aluno.getIdMoip();

	}	
	
	public AlunoDTO(String nome, String ra, String codigoCartao, String idMoip) {
		this.nomeAluno = nome;
		this.registroAluno = ra;
		this.codigoCartao = codigoCartao;
		this.idMoip = idMoip;
	}
	

	public String getRegistroAluno() {
		return registroAluno;
	}
	public void setRegistroAluno(String registroAluno) {
		this.registroAluno = registroAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getCodigoCartao() {
		return codigoCartao;
	}
	public void setCodigoCartao(String codigoCartao) {
		this.codigoCartao = codigoCartao;
	}
	public String getIdMoip() {
		return idMoip;
	}
	public void setIdMoip(String idMoip) {
		this.idMoip = idMoip;
	}

}
