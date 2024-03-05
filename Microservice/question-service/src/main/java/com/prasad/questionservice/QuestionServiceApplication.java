package com.prasad.questionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionServiceApplication.class, args);
	}

}



//generate
// getQuestions(questionid)
// getscore
// This are the things to do in question service



// We can create two instances or more from this question service , just we should have two different ports for them
// Search on you tube how to create two instances of a service in Intellij