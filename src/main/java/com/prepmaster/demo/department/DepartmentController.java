package com.prepmaster.demo.department;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/departments")
@AllArgsConstructor// creates a constructor, so we don't have too (Lombok)
@RestController// Allows us to send http requests into it
@CrossOrigin(origins = "https://prepmaster-api-xwoy.onrender.com/api")
public class DepartmentController {
    private DepartmentService departmentService;
    @PostMapping
    void createDepartment(@Valid @RequestBody DepartmentRequestBody departmentRequestBody){
        departmentService.createNewDepartment(departmentRequestBody);
    }
    @PutMapping
    void updateDepartment(@Valid @RequestBody DepartmentRequestBodyUpdate departmentRequestBody){
        departmentService.updateDepartment(departmentRequestBody);
    }
    @GetMapping
    List<Department> getDepartments(){
        return departmentService.getDepartments();
    }
    @GetMapping(path = "{departmentId}")
    Department getDepartment(@Valid @PathVariable("departmentId")Long id){
        return departmentService.getDepartment(id);
    }
    @DeleteMapping(path = "{departmentId}")
    void deleteDepartment (@Valid @PathVariable("departmentId")Long id) {
         departmentService.deleteDepartment(id);
    }

    @GetMapping(path = "{departmentId}/statistics")
    DepartmentStatistics getStatistics(@Valid @PathVariable("departmentId")Long id){
        return departmentService.getStatistics(id);
    }
}
