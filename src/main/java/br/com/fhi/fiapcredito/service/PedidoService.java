package br.com.fhi.fiapcredito.service;

import java.util.List;

import br.com.fhi.fiapcredito.dto.PedidoDTO;

public interface PedidoService {
	
	List<PedidoDTO> getPedidos();
	PedidoDTO criarPedido(PedidoDTO novoPedido);
    void deletarPedido(String id);

}
