package br.com.fhi.fiapcredito.config;

import br.com.fhi.fiapcredito.dto.AlunoDTO;
import br.com.fhi.fiapcredito.service.AlunoService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

import br.com.fhi.fiapcredito.dto.AlunoDTO;
import br.com.fhi.fiapcredito.service.AlunoService;
import br.com.moip.Moip;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.BasicAuth;
import br.com.moip.models.Setup;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;


@Component
public class AlunoTxtLoader implements ApplicationRunner {

	private AlunoService alunoService;

	public AlunoTxtLoader(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	private Path getFilePath() throws URISyntaxException {
		return Paths.get(getClass().getClassLoader().getResource("lista_alunos.txt").toURI());
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try (Stream<String> lines = Files.lines(getFilePath())) {
			lines.filter(line -> !line.startsWith("-")).filter(line -> !line.isBlank())
					.filter(line -> line.length() == 55).forEach(line -> {
						AlunoDTO novoAluno = new AlunoDTO();
						novoAluno.setNomeAluno(line.substring(0, 40).replaceAll("\\s+$", ""));
						novoAluno.setRegistroAluno(line.substring(41, 48));
						novoAluno.setCodigoCartao(line.substring(50, 55));
				    	String token = "QHSDKTLIMA7MTNCLZWAFXSLNUTDCSKIZ";
				    	String key = "7JP4ONJAYNFNYSKGM9ZQVCNV2UYCLKBUBAG1WFQS";
				    	Authentication auth = new BasicAuth(token, key);
				    	Setup setup = new Setup().setAuthentication(auth).setEnvironment(Setup.Environment.SANDBOX);
				    	Map<String, Object> taxDocument = payloadFactory(
				    	        value("type", "CPF"),
				    	        value("number", "10013390023")
				    	);
				    	Map<String, Object> phone = payloadFactory(
				    	        value("countryCode", "55"),
				    	        value("areaCode", "11"),
				    	        value("number", "22226842")
				    	);
				    	Map<String, Object> customerRequestBody = payloadFactory(
				    	        value("ownId", novoAluno.getRegistroAluno()),
				    	        value("fullname", novoAluno.getNomeAluno()),
				    	        value("email", "test.moip@mail.com"),
				    	        value("birthDate", "1980-5-10"),
				    	        value("taxDocument", taxDocument),
				    	        value("phone", phone)
				    	);
				    	Map<String, Object> responseCreation = Moip.API.customers().create(customerRequestBody, setup);
				    	novoAluno.setIdMoip(responseCreation.get("id").toString());
						alunoService.criarAluno(novoAluno);
					});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
