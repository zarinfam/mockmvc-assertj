package com.saeed.demo_mockmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoMockmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMockmvcApplication.class, args);
	}

	@GetMapping("hello")
	public String hello() {
		return "Hello Spring!";
	}

}
