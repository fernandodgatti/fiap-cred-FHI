package br.com.fhi.fiapcredito.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import br.com.fhi.fiapcredito.dto.AlunoDTO;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno {
	
	@Id
	@Column(name = "registro_aluno", nullable = false)
	private String registroAluno;
	
	@Column(name = "nome_aluno", nullable = false)
	private String nomeAluno;
	
	@Column(name = "codigo_cartao", nullable = false)
	private String codigoCartao;
	
	@Column(name = "id_moip", nullable = false)
	private String idMoip;
	
	public Aluno() {}
	
	public Aluno(AlunoDTO alunoDTO) {
		this.registroAluno = alunoDTO.getRegistroAluno();
		this.nomeAluno = alunoDTO.getNomeAluno();
		this.codigoCartao = alunoDTO.getCodigoCartao();
		this.idMoip = alunoDTO.getIdMoip();

	}
	
	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getRegistroAluno() {
		return registroAluno;
	}

	public void setRegistroAluno(String registroAluno) {
		this.registroAluno = registroAluno;
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
