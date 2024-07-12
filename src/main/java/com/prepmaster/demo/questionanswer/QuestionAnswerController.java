package com.prepmaster.demo.questionanswer;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/question_answers")
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "https://prepmaster-api-xwoy.onrender.com/api")
public class QuestionAnswerController {
    private QuestionAnswerService questionAnswerService;

    @PostMapping
    void createQuestionAnswer(@Valid @RequestBody QuestionAnswerRequestBody questionAnswerRequestBody){
        questionAnswerService.createQuestionAnswer(questionAnswerRequestBody);
    }
    @GetMapping(path = "{questionId}/{testId}")
    QuestionAnswer readQuestionAnswer(
            @Valid @PathVariable("questionId") Long questionId,
            @Valid  @PathVariable("testId") Long testId
    ) {
        return questionAnswerService.getQuestionAnswer(new QuestionAnswerID(testId,questionId));
    }
    @PutMapping
    void updateQuestionAnswer(@Valid @RequestBody QuestionAnswerRequestBody questionAnswerRequestBody){
        questionAnswerService.updateQuestionAnswer(questionAnswerRequestBody);
    }
    @DeleteMapping(path = "{questionId}/{testId}")
    void deleteQuestionAnswer(
            @Valid @PathVariable("questionId") Long questionId,
            @Valid  @PathVariable("testId") Long testId
    ) {
        questionAnswerService.deleteQuestionAnswer(new QuestionAnswerID(testId,questionId));
    }
    @GetMapping
    List<QuestionAnswer> getQuestionAnswer(){
        return questionAnswerService.getQuestionAnswers();
    }
}
