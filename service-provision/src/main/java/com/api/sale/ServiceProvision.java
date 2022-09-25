package com.api.sale;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.api.sale.entities.Client;
import com.api.sale.entities.Labor;
import com.api.sale.repositories.ClientRepository;
import com.api.sale.repositories.LaborRepository;

@SpringBootApplication
public class ServiceProvision {

	@Bean
	CommandLineRunner run(ClientRepository clientRepository, LaborRepository laborRepository) {
		return args -> {
			Client client = Client.builder().cpf("90821388088").name("Fulano de tal").build();
			clientRepository.save(client);

			Labor labor = Labor.builder().client(client).description("Formatação de PC").date(LocalDate.now())
					.amount(34.90)
					.build();
			laborRepository.save(labor);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceProvision.class, args);
	}

}
