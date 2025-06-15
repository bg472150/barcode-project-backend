package com.barcode.scanapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.barcode.scanapi.repository")
public class ScanapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScanapiApplication.class, args);
	}

}
