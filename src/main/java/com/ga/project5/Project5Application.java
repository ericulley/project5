package com.ga.project5;

import com.ga.project5.coin.Coin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class Project5Application {

	public static void main(String[] args) {
		SpringApplication.run(Project5Application.class, args);
	}

}
