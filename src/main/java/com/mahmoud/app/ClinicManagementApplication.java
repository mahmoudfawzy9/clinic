package com.mahmoud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
//@ComponentScan({ "com.mahmoud" }) // If our Controller class or Service class is not in the same packages we have //to add packages's name like this...directory(package) with main class
@ComponentScan
//@EnableSwagger2
@ComponentScan(basePackages = "com.mahmoud.app")
public class ClinicManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicManagementApplication.class, args);
	}

//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.mahmoud")).build();
//	}
}
