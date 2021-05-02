package br.com.fhi.fiapcredito.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import br.com.fhi.fiapcredito.dto.AlunoDTO;
import br.com.fhi.fiapcredito.entity.Pedido;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno {
	
	@Id
	@Column(name = "registro_aluno", nullable = false)
	private int registroAluno;
	
	@Column(name = "nome_aluno", nullable = false)
	private String nomeAluno;
	
	@Column(name = "codigo_cartao", nullable = false)
	private String codigoCartao;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "aluno")
	private Set<Pedido> pedidos = new LinkedHashSet<Pedido>();
	
	public Aluno() {}
	
	public Aluno(AlunoDTO alunoDTO) {
		this.registroAluno = alunoDTO.getRegistroAluno();
		this.nomeAluno = alunoDTO.getNomeAluno();
		this.codigoCartao = alunoDTO.getCodigoCartao();
	}
	
	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public int getRegistroAluno() {
		return registroAluno;
	}

	public void setRegistroAluno(int registroAluno) {
		this.registroAluno = registroAluno;
	}

	public String getCodigoCartao() {
		return codigoCartao;
	}

	public void setCodigoCartao(String codigoCartao) {
		this.codigoCartao = codigoCartao;
	}

	
	

}
