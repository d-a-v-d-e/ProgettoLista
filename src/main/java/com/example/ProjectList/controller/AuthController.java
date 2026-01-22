package com.example.ProjectList.controller;


import com.example.ProjectList.service.UserService;
import com.example.ProjectList.model.User;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public User Register(@RequestParam String username,
                         @RequestParam String chosenName,
                         @RequestParam String password){
        return userService.register(username, chosenName, password);
    }

    @GetMapping("/login")
    public String login(){
        return "login ok";
    }
}
