package br.com.fhi.fiapcredito.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import br.com.fhi.fiapcredito.validator.AlunoValidator;
import br.com.fhi.fiapcredito.validator.AlunoValidatorImpl;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class AppConfiguration {

	@Bean
	public AlunoValidator alunoValidator() {
		return new AlunoValidatorImpl();
	}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .paths(PathSelectors.any())
        .build();
	}
}
