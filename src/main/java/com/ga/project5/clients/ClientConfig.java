package com.ga.project5.clients;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner2(ClientRepository repository) {
        return args -> {
            Client bob = new Client(
                    "bob",
                    "bob@bob.com",
                    "passssssword"
            );
            repository.saveAll(
                    List.of(bob));
        };
    }
}
