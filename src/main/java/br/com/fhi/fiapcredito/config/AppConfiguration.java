package br.com.fhi.fiapcredito.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fhi.fiapcredito.validator.AlunoValidator;
import br.com.fhi.fiapcredito.validator.AlunoValidatorImpl;

@Configuration
public class AppConfiguration {

	@Bean
	public AlunoValidator alunoValidator() {
		return new AlunoValidatorImpl();
	}
}
