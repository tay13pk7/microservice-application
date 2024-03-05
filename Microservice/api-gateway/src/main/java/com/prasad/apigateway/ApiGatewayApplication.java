package com.prasad.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}


// examples

// http://localhost:8089/quiz-service/quiz/get/1

// http://localhost:8089/question-service/question/allQuestions