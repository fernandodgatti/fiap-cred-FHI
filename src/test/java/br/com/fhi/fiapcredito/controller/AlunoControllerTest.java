package br.com.fhi.fiapcredito.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.fhi.fiapcredito.dto.AlunoDTO;
import br.com.fhi.fiapcredito.service.AlunoService;

public class AlunoControllerTest {

	@Mock
	private AlunoService alunoService;

	AlunoController alunoController;

	@Test
	public void DeveRetornarTodosAlunos() throws Exception {
		AlunoController alunoController = new AlunoController(alunoService);
		List<AlunoDTO> alunoList = alunoController.getAlunos();

		Assertions.assertEquals(1, alunoList.size());
	}
	
	@Test
	public void DeveRetornarTodosAlunos() throws Exception {
		AlunoController alunoController = new AlunoController(alunoService);
		List<AlunoDTO> alunoList = alunoController.getAlunos();

		Assertions.assertEquals(1, alunoList.size());
	}
	
	@Test
	public void DeveRetornarTodosAlunos() throws Exception {
		AlunoController alunoController = new AlunoController(alunoService);
		List<AlunoDTO> alunoList = alunoController.getAlunos();

		Assertions.assertEquals(1, alunoList.size());
	}
	
	@Test
	public void DeveRetornarTodosAlunos() throws Exception {
		AlunoController alunoController = new AlunoController(alunoService);
		List<AlunoDTO> alunoList = alunoController.getAlunos();

		Assertions.assertEquals(1, alunoList.size());
	}
}
