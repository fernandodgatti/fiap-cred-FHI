package br.com.fhi.fiapcredito.service;

import java.util.List;

import br.com.fhi.fiapcredito.dto.PedidoDTO;
import br.com.fhi.fiapcredito.dto.NovoPedidoDTO;

public interface PedidoService {
	
	List<PedidoDTO> getPedidos();
	PedidoDTO criarPedido(NovoPedidoDTO novoPedido);
    void deletarPedido(String id);

}
