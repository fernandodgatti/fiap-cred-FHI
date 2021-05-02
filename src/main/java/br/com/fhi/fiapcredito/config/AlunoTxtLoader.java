package br.com.fhi.fiapcredito.config;

import br.com.fhi.fiapcredito.dto.AlunoDTO;
import br.com.fhi.fiapcredito.service.AlunoService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

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
						AlunoDTO novoAluno = new AlunoDTO(line.substring(0, 40).replaceAll("\\s+$", ""),
								line.substring(41, 48), line.substring(50, 55));
						alunoService.criarAluno(novoAluno);
					});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
