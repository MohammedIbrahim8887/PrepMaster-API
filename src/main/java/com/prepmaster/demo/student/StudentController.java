package com.prepmaster.demo.student;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/students")
@AllArgsConstructor// creates a constructor, so we don't have too (Lombok)
@RestController// Allows us to send http requests into it
@CrossOrigin(origins = "https://prepmaster-api-xwoy.onrender.com/api")
public class StudentController {
    private StudentService studentService;
    @PostMapping
    void createStudent(@Valid @RequestBody StudentRequestBody studentRequestBody ){
        studentService.createNewStudent(studentRequestBody);
    }
    @GetMapping(path="{studentId}")
    Student readStudent(@Valid @PathVariable("studentId")Long id){
        return  studentService.getStudent(id);
    }
    @GetMapping
    List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PutMapping
    void updateStudent(@Valid @RequestBody StudentRequestBody studentRequestBody){
        studentService.updateStudent(studentRequestBody);
    }
    @DeleteMapping(path="{studentId}")
    void deleteStudent(@Valid @PathVariable("studentId")Long id){
          studentService.deleteStudent(id);
    }
    @GetMapping(path="{studentId}/statistics")
    StudentStatistics getStatistics(@Valid @PathVariable("studentId")Long id){
        return  studentService.getStatistics(id);
    }
}
