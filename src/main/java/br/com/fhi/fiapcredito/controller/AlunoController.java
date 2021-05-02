package br.com.fhi.fiapcredito.controller;

import java.util.List;

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


@RestController
@RequestMapping("alunos")
public class AlunoController {

	private final AlunoService alunoService;
	

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping
	public List<AlunoDTO> getMusicas() {
		return alunoService.getAlunos();
	}
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO criarMusica(
            @RequestBody AlunoDTO novoAluno
    ) {
        return alunoService.criarAluno(novoAluno);
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAluno(
            @PathVariable String id
    ){
        alunoService.deletarAluno(id);
    }
	

}
