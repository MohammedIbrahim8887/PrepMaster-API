package com.prepmaster.demo.course;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path = "/api/courses")
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "https://prepmaster-api-xwoy.onrender.com/api")
public class CourseController {
    private CourseService courseService;

    @PostMapping
    void createCourse(@Valid @RequestBody CourseRequestBody courseRequestBody){
        courseService.createNewCourse(courseRequestBody);
    }
    @GetMapping(path = "{courseId}")
    Course readCourse(@Valid @PathVariable("courseId") Long id) {
        return courseService.getCourse(id);
    }
    @PutMapping
    void updateCourse(@Valid @RequestBody CourseRequestBody courseRequestBody){
        courseService.updateCourse(courseRequestBody);
    }
    @DeleteMapping(path = "{courseId}")
    void deleteCourse(@PathVariable("courseId") Long id){
        courseService.deleteCourse(id);
    }

    @GetMapping
    List<Course> getCourses(){
        return courseService.getCourses();
    }
}
