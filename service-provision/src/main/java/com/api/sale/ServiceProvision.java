package com.api.sale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.api.sale.entities.Client;
import com.api.sale.repositories.ClientRepository;

@SpringBootApplication
public class ServiceProvision {

	@Bean
	CommandLineRunner run(ClientRepository clientRepository) {
		return args -> {
			Client client = Client.builder().cpf("90821388088").name("Fulano de tal").build();
			clientRepository.save(client);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceProvision.class, args);
	}

}
