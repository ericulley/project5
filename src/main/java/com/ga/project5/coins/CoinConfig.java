package com.ga.project5.coins;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CoinConfig {

    @Bean
    CommandLineRunner commandLineRunner(CoinRepository repository) {
        return args -> {
            Coin bitcoin = new Coin(
                    "bitcoin",
                    "BTC",
                    35678.56,
                    0.125,
                    0
            );

            Coin litecoin = new Coin(
                    "litecoin",
                    "LTC",
                    92.01,
                    2.5,
                    0
            );

            repository.saveAll(
                    List.of(bitcoin, litecoin)
            );
        };
    }
}
