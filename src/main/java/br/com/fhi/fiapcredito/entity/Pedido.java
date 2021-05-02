package br.com.fhi.fiapcredito.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fhi.fiapcredito.dto.PedidoDTO;

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

	@Id
	@Column(name = "id_pedido", nullable = false)
	private String codigoPedido;
	
	@Column(name = "codigo_pedido_moip", nullable = false)
	private String codigoPedidoMoip;

	public Pedido() {
	}

	public Pedido(PedidoDTO pedidoDTO) {
		this.codigoPedido = pedidoDTO.getCodigoPedido();
		this.codigoPedidoMoip = pedidoDTO.getCodigoPedidoMoip();
		
	}
	
	public Pedido(String codigoPedido, String codigoPedidoMoip) {
		this.codigoPedido = codigoPedido;
		this.codigoPedidoMoip = codigoPedidoMoip;
		
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
