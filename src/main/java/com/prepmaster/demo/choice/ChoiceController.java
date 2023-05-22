package com.prepmaster.demo.choice;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/choices")
@AllArgsConstructor
@RestController
public class ChoiceController {
    private ChoiceService choiceService;
    @GetMapping
    List<Choice> readChoices(){
        return choiceService.getChoices();
    }
    @GetMapping(path = "{choiceId}")
    Choice readChoice(@Valid @PathVariable("choiceId")Long id){
        return choiceService.getChioce(id);
    }
    @PostMapping
    void createChoice(@Valid @RequestBody ChoiceRequestBody choiceRequestBody){
        choiceService.createNewChoice(choiceRequestBody);
    }
    @DeleteMapping(path = "{choiceId}")
    void deleteChoice(@Valid @PathVariable("choiceId")Long id){
         choiceService.deleteChoice(id);
    }
    @PutMapping
    void updateChoice(@Valid @RequestBody ChoiceRequestBody choiceRequestBody){
        choiceService.createUpdateChoice(choiceRequestBody);
    }

}
