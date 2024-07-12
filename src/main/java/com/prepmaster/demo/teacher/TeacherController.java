package com.prepmaster.demo.teacher;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/teachers")
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "https://prepmaster-api-xwoy.onrender.com/api")
public class TeacherController {
    private TeacherService teacherService;

    @PostMapping
    void createTeacher(@Valid @RequestBody TeacherRequestBody teacherRequestBody){
        teacherService.createNewTeacher(teacherRequestBody);
    }

    @GetMapping(path = "{teacherId}")
    Teacher readTeacher(@Valid @PathVariable("teacherId") Long id){
        return teacherService.getTeacher(id);
    }

    @PutMapping
    void updateTeacher(@Valid @RequestBody TeacherRequestBody teacherRequestBody){
        teacherService.updateTeacher(teacherRequestBody);
    }

    @DeleteMapping(path = "{teacherId}")
    void deleteTeacher(@PathVariable("teacherId") Long id){
        teacherService.deleteTeacher(id);
    }

    @GetMapping
    List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @GetMapping(path="{teacherId}/statistics")
    TeacherStatistics getStatistics(@Valid @PathVariable("teacherId")Long id){
        return  teacherService.getStatistics(id);
    }
}
