package com.academiacx.projetofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProjetoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}

}
