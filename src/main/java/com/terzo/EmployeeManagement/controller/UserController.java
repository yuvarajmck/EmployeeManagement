package com.terzo.EmployeeManagement.controller;

import com.terzo.EmployeeManagement.Service.UserService;
import com.terzo.EmployeeManagement.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {


    @Autowired
    public UserController( UserService userService) {

        this.userService = userService;
    }

    private final UserService userService;



    @PostMapping("/register")
    public void userRegistration(@RequestBody UserEntity user){
        userService.saveUser(user);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteUser(@RequestParam @PathVariable long employeeId){
        userService.delete(employeeId);
    }

    @GetMapping("/register")
    public List<UserEntity> userInfo(){
        return userService.findAllUsers();
    }

}
