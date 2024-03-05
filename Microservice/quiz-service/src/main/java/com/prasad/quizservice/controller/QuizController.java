package com.prasad.quizservice.controller;


import com.prasad.quizservice.model.QuestionWrapper;
import com.prasad.quizservice.model.QuizDto;
import com.prasad.quizservice.model.Response;
import com.prasad.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto)
    {
        return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
    {
       return  quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id , @RequestBody List<Response> responses)
    {
      return  quizService.calculateResult(id,responses);
    }


}


// http://localhost:8080/quiz/create?category=Java&numQ=2&title=JQuiz
// http://localhost:8080/quiz/create?category=Football&numQ=5&title=FootballQuiz

// http://localhost:8080/quiz/get/2

// http://localhost:8080/quiz/submit/2



//[
//        {
//        "id":2,
//        "response":"*"
//        },
//        {
//        "id":52,
//        "response":"Cristiano Ronaldo"
//        },
//        {
//        "id":203,
//        "response":"Real Madrid"
//        },
//        {
//        "id":202,
//        "response":"Real Madrid"
//        },
//        {
//        "id":102,
//        "response":"Messi"
//        }
//        ]