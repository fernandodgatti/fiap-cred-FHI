package br.com.fhi.fiapcredito.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.fhi.fiapcredito.dto.NovoPagamentoDTO;
import br.com.fhi.fiapcredito.service.PagamentoService;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

	private PagamentoService pagamentoService;

	public PagamentoController(PagamentoService pagamentoService) {

		this.pagamentoService = pagamentoService;
	}

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public String novoPagamento(
			 @RequestBody NovoPagamentoDTO novoPagamento
			) {
		return pagamentoService.efetuarPagamento(novoPagamento);
	}

}
