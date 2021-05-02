package br.com.fhi.fiapcredito.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.fhi.fiapcredito.dto.PedidoDTO;
import br.com.fhi.fiapcredito.dto.NovoPedidoDTO;
import br.com.fhi.fiapcredito.service.PedidoService;


@Controller
@RequestMapping("pedidos")
public class PedidoController {

	private final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping
	public List<PedidoDTO> getPedidos() {
		return pedidoService.getPedidos();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoDTO criarMusica(@RequestBody NovoPedidoDTO novoPedido) {
		return pedidoService.criarPedido(novoPedido);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarAluno(@PathVariable String id) {
		pedidoService.deletarPedido(id);
	}
	
}
