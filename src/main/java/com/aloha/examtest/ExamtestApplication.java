package com.aloha.examtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamtestApplication.class, args);

		System.out.println("===== Swagger api By Nho Nam ======");
		System.err.println("http://localhost:8080/swagger-ui/index.html");
		System.err.println("/v3/api-docs");
		System.out.println("===== Swagger api By Nho Nam ======");
	}

}
