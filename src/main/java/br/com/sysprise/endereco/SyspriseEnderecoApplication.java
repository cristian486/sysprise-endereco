package br.com.sysprise.endereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SyspriseEnderecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyspriseEnderecoApplication.class, args);
	}

}
