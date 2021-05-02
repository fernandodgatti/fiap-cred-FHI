package br.com.fhi.fiapcredito.dto;

import br.com.fhi.fiapcredito.entity.Aluno;
import br.com.fhi.fiapcredito.entity.Pedido;

public class PedidoDTO {
	
	private int codigoPedido;
	private Aluno aluno;
	
	public PedidoDTO() {}
	
	public PedidoDTO(Pedido pedido) {
		this.codigoPedido = pedido.getCodigoPedido();
			}
	
	public int getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}	

}
