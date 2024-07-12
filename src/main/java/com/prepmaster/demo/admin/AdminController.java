package com.prepmaster.demo.admin;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/admins")
@AllArgsConstructor// creates a constructor, so we don't have too (Lombok)
@RestController// Allows us to send http requests into it
@CrossOrigin(origins = "https://prepmaster-api-xwoy.onrender.com/api")
public class AdminController {
    private AdminService adminService;

    @PostMapping
    void createAdmin(@Valid @RequestBody Admin admin){
//        @Valid activates the constraints but on customer like @NotBlank
//        @RequestBody maps the json payload and maps it to admin
        adminService.createNewAdmin(admin);
//        return 1;//1 is success
    }
    @GetMapping(path = "{adminId}")
    Admin readAdmin(@Valid @PathVariable("adminId") Long id) {
        return adminService.getAdmin(id);
    }

    @PutMapping
    void updateAdmin(@Valid @RequestBody Admin admin){
        adminService.updateAdmin(admin);
    }
    @DeleteMapping(path = "{adminId}")
    void deleteAdmin(@PathVariable("adminId") Long id){
        adminService.deleteAdmin(id);
    }

    @GetMapping(path = "{adminId}/statistics")
    AdminStatistics getStatistics(@Valid @PathVariable("adminId")Long id){
        return adminService.getStatistics(id);
    }

    @GetMapping()
    List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }
}
