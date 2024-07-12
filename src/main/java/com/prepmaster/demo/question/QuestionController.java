package com.prepmaster.demo.question;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/questions")
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "https://prepmaster-api-xwoy.onrender.com/api")
public class QuestionController {
    private QuestionService questionService;
    @GetMapping
    List<Question> readQuestions(){
        return questionService.getQuestions();
    }
    @GetMapping(path = "{questionId}")
    Question readQuestion(@Valid @PathVariable("questionId") Long id) {
        return questionService.getQuestion(id);
    }
    @PostMapping
    void createQuestion(@Valid @RequestBody QuestionRequestBody questionRequestBody){
        questionService.createNewQuestion(questionRequestBody);
    }
    @PutMapping
    void updateQuestion(@Valid @RequestBody QuestionRequestBody questionRequestBody){
        questionService.updateQuestion(questionRequestBody);
    }
    @DeleteMapping(path = "{questionId}")
    void deleteQuestion(@PathVariable("questionId") Long id){
        questionService.deleteQuestion(id);
    }

    @GetMapping(path = "{questionId}/answer")
    String getAnswerText(@Valid @PathVariable("questionId") Long id) {
        return questionService.getAnswerText(id);
    }
}
