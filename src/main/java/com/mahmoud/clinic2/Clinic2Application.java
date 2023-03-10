package com.mahmoud.clinic2;

import com.mahmoud.clinic2.config.MyDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableJpaRepositories("com.mahmoud.clinic2.repository")
@ComponentScan(basePackages = { "com.mahmoud.clinic2.*" })
@ComponentScan(basePackageClasses = {MyDataRestConfig.class})
@SpringBootApplication
public class Clinic2Application {

	public static void main(String[] args) {
		SpringApplication.run(Clinic2Application.class, args);
	}

//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.mahmoud.clinic2")).build();
//	}
}