package com.sportyshoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories("com.Dao")
@EntityScan("com.bean")
@ComponentScan("com")
@SpringBootApplication
public class SportyshoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyshoesApplication.class, args);
	}

}
