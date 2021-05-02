package br.com.fhi.fiapcredito.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fhi.fiapcredito.dto.AlunoDTO;
import br.com.fhi.fiapcredito.entity.Aluno;
import br.com.fhi.fiapcredito.repository.AlunoRepository;
import br.com.fhi.fiapcredito.validator.AlunoValidator;

@Service
public class AlunoServiceImpl implements AlunoService {

	private final AlunoRepository alunoRepository;
	private final AlunoValidator alunoValidator;

	public AlunoServiceImpl(AlunoRepository alunoRepository, AlunoValidator alunoValidator) {
		this.alunoRepository = alunoRepository;
		this.alunoValidator = alunoValidator;
	}

	@Override
	public List<AlunoDTO> getAlunos() {
		List<Aluno> alunoList;
		alunoList = alunoRepository.findAll();
		
		 return alunoList.stream()
	                .map(AlunoDTO::new)
	                .collect(Collectors.toList());
	}
	
	@Override
    public AlunoDTO getAlunoByRa(String ra) {
        Aluno aluno = findAlunoByRa(ra);
        return new AlunoDTO(aluno);
    }
	
	@Override
    public AlunoDTO criarAluno(AlunoDTO novoAlunoDTO) {
        Aluno aluno = new Aluno(novoAlunoDTO);
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return new AlunoDTO(alunoSalvo);
    }
	
	@Override
    public void deletarAluno(String ra) {
		findAlunoByRa(ra);
        alunoRepository.deleteById(ra);
    }

	private Aluno findAlunoByRa(String ra) {
		return alunoRepository.findById(ra).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
