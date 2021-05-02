package br.com.fhi.fiapcredito.service;

import br.com.fhi.fiapcredito.dto.NovoPagamentoDTO;

public interface PagamentoService {

	String efetuarPagamento(NovoPagamentoDTO novoPagamento);
}
