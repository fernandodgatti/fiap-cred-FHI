package br.com.fhi.fiapcredito.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fhi.fiapcredito.dto.PedidoDTO;
import br.com.fhi.fiapcredito.entity.Pedido;
import br.com.fhi.fiapcredito.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	private final PedidoRepository pedidoRepository;

	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@Override
	public List<PedidoDTO> getPedidos() {
		List<Pedido> pedidoList;
		pedidoList = pedidoRepository.findAll();

		return pedidoList.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}

	@Override
	public PedidoDTO criarPedido(PedidoDTO novoPedidoDTO) {
		Pedido pedido = new Pedido(novoPedidoDTO);
		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		return new PedidoDTO(pedidoSalvo);
	}

	@Override
	public void deletarPedido(String id) {
		findPedidoById(id);
		pedidoRepository.deleteById(id);
	}

	private Pedido findPedidoById(String id) {
		return pedidoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
