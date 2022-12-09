package com.sports.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GoSportsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoSportsBackendApplication.class, args);
	}

}
