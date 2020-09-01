package br.com.jrcsofthouse.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.jrcsoft"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("RESTFUL API WITH SPRINGBOOT 2.1.3",
				"Api desenvolvida para aprendizado do curso REST WITH SPRINGBOOT API AWS",
				 "v1", 
				 "Terms of Licence URL",
				 new Contact("ContractzIT", "www.contractz.it", "admcontractz@contractz.it"),
				 "Free",
				 " ",
				 Collections.emptyList());
	}
}
