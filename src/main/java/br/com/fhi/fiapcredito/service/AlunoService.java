package br.com.fhi.fiapcredito.service;

import java.util.List;

import br.com.fhi.fiapcredito.dto.AlunoDTO;

public interface AlunoService {
	
	List<AlunoDTO> getAlunos();
	AlunoDTO getAlunoByRa(int Ra);
	AlunoDTO criarAluno(AlunoDTO novoAluno);
    void deletarAluno(int Ra);

}
