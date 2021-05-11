package br.com.fhi.fiapcredito.service;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fhi.fiapcredito.dto.PedidoDTO;
import br.com.fhi.fiapcredito.dto.NovoPedidoDTO;
import br.com.fhi.fiapcredito.entity.Pedido;
import br.com.fhi.fiapcredito.repository.PedidoRepository;
import br.com.moip.Moip;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.BasicAuth;
import br.com.moip.models.Setup;

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
	public PedidoDTO criarPedido(NovoPedidoDTO novoPedidoDTO) {
		String codigoPedidoMoip = enviarPedidoMoip(novoPedidoDTO.getCodigoClienteMoip());
		Pedido pedido = new Pedido(novoPedidoDTO.getCodigoPedido(), codigoPedidoMoip);
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

	public String enviarPedidoMoip(String codigoClienteMoip) {
		Random gerador = new Random();
		String token = "QHSDKTLIMA7MTNCLZWAFXSLNUTDCSKIZ";
		String key = "7JP4ONJAYNFNYSKGM9ZQVCNV2UYCLKBUBAG1WFQS";
		Authentication auth = new BasicAuth(token, key);
		Setup setup = new Setup().setAuthentication(auth).setEnvironment(Setup.Environment.SANDBOX);

		Map<String, Object> amount = payloadFactory(value("currency", "BRL"));
		Map<String, Object> product1 = payloadFactory(value("product", "Cartão FIAP"), value("quantity", 1),
				value("price", 10000));
		List items = new ArrayList();
		items.add(product1);
		Map<String, Object> customer = payloadFactory(value("id", codigoClienteMoip));
		Map<String, Object> order = payloadFactory(value("ownId", gerador.nextInt(10000000)), value("amount", amount),
				value("items", items), value("customer", customer));
		Map<String, Object> responseCreation = Moip.API.orders().create(order, setup);
		return responseCreation.get("id").toString();
	}

}
