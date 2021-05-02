package br.com.fhi.fiapcredito.dto;

import br.com.fhi.fiapcredito.entity.Aluno;

public class AlunoDTO {
	
	private int registroAluno;
	private String nomeAluno;
	private String codigoCartao;
	
	public AlunoDTO() {
		
	}
	
	public AlunoDTO(Aluno aluno) {
		this.registroAluno = aluno.getRegistroAluno();
		this.nomeAluno = aluno.getNomeAluno();
		this.codigoCartao = aluno.getCodigoCartao();
	}	
	
	public int getRegistroAluno() {
		return registroAluno;
	}
	public void setRegistroAluno(int registroAluno) {
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
	
	

}
