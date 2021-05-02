package br.com.fhi.fiapcredito.dto;

import br.com.fhi.fiapcredito.entity.Aluno;
import br.com.fhi.fiapcredito.entity.Pedido;

public class PedidoDTO {

	private String codigoPedido;
	private String codigoPedidoMoip;
	
	public PedidoDTO() {
	}

	public PedidoDTO(Pedido pedido) {
		this.codigoPedido = pedido.getCodigoPedido();
		this.codigoPedidoMoip = pedido.getCodigoPedidoMoip();
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getCodigoPedidoMoip() {
		return codigoPedidoMoip;
	}

	public void setCodigoPedidoMoip(String codigoClienteMoip) {
		this.codigoPedidoMoip = codigoClienteMoip;
	}
	
}
