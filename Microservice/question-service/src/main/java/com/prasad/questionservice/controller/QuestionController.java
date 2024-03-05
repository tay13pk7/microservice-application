package com.prasad.questionservice.controller;



import com.prasad.questionservice.model.Question;
import com.prasad.questionservice.model.QuestionWrapper;
import com.prasad.questionservice.model.Response;
import com.prasad.questionservice.service.QuestionService;
//import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("question")
public class QuestionController {


    @Autowired
    QuestionService questionService;

//    @Autowired
//    Environment environment;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getallQuestions()
    {
        return  questionService.getallQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
    {
            return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }

    @GetMapping("generate")
    public  ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions)
    {
        return questionService.getQuestionsForQuiz(categoryName,numQuestions);
    }

    @PostMapping("getQuestions")
    public  ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionsIds)
    {
       // System.out.println(environment.getProperty("local.server.port"));  Load Balancing is done with help of eureka and feign client
        return questionService.getQuestionsFromId(questionsIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return questionService.getScore(responses);
    }




}


// http://localhost:8080/question/allQuestions
