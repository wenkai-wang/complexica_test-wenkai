package com.wenkai.server.complexicatest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableTransactionManagement
@EnableAutoConfiguration
@EnableWebMvc
@SpringBootApplication(scanBasePackages = "com.wenkai.server.complexicatest")
public class ComplexicaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplexicaTestApplication.class, args);
	}
}
