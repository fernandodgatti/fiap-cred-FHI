package br.com.fhi.fiapcredito.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fhi.fiapcredito.dto.AlunoDTO;
import br.com.fhi.fiapcredito.service.AlunoService;
import br.com.moip.Moip;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.BasicAuth;
import br.com.moip.models.Setup;
import springfox.documentation.annotations.ApiIgnore;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

@RestController
@RequestMapping("alunos")
public class AlunoController {

	private final AlunoService alunoService;
	

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping
	public List<AlunoDTO> getAlunos() {
		return alunoService.getAlunos();
	}
	@ApiIgnore
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO criarAluno(
            @RequestBody AlunoDTO novoAluno
    ) {
    	String moipId = gerarMoipId(novoAluno);
    	
    	novoAluno.setIdMoip(moipId);
        return alunoService.criarAluno(novoAluno);
    }
    @ApiIgnore
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAluno(
            @PathVariable String id
    ){
        alunoService.deletarAluno(id);
    }
    
    private String gerarMoipId (AlunoDTO novoAluno) {
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
    	return responseCreation.get("id").toString();
    }
	

}
