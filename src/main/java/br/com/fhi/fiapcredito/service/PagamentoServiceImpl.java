package br.com.fhi.fiapcredito.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.fhi.fiapcredito.dto.NovoPagamentoDTO;
import br.com.moip.Moip;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.BasicAuth;
import br.com.moip.models.Setup;

@Service
public class PagamentoServiceImpl implements PagamentoService {

	@Override
	public String efetuarPagamento(NovoPagamentoDTO novoPagamento) {
				
		String token = "QHSDKTLIMA7MTNCLZWAFXSLNUTDCSKIZ";
		String key = "7JP4ONJAYNFNYSKGM9ZQVCNV2UYCLKBUBAG1WFQS";
		Authentication auth = new BasicAuth(token, key);
		Setup setup = new Setup().setAuthentication(auth).setEnvironment(Setup.Environment.SANDBOX);

		Map<String, Object> taxDocument = payloadFactory(value("type", "CPF"), value("number", "33333333333"));

		Map<String, Object> holder = payloadFactory(value("fullname", "Portador Teste Moip"),
				value("birthdate", "1988-12-30"), value("taxDocument", taxDocument));

		Map<String, Object> creditCard = payloadFactory(
				value("number", novoPagamento.getNumeroCartao()),
				value("expirationMonth", novoPagamento.getMesExpiracao()),
				value("expirationYear", novoPagamento.getAnoExpiracao()), 
				value("cvc", novoPagamento.getCvc()),
				value("holder", holder),
				value("store", true));

		Map<String, Object> fundingInstrument = payloadFactory(value("method", "CREDIT_CARD"),
				value("creditCard", creditCard));
		
		Map<String, Object> payment = payloadFactory(value("installmentCount", 1),
				value("fundingInstrument", fundingInstrument));

		Map<String, Object> newPay = Moip.API.payments().pay(payment, novoPagamento.getIdPagamento(), setup);
		return newPay.toString();
	}
	
}
