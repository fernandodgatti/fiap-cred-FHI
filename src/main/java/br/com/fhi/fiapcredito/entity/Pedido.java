package br.com.fhi.fiapcredito.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.fhi.fiapcredito.dto.PedidoDTO;

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

	@Id
	@Column(name = "id_pedido", nullable = false)
	private int codigoPedido;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "registro_aluno")
	private Aluno aluno;

	public Pedido() {
	}

	public Pedido(PedidoDTO pedidoDTO) {
		this.codigoPedido = pedidoDTO.getCodigoPedido();
		this.aluno = pedidoDTO.getAluno();

	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setRegistroAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
