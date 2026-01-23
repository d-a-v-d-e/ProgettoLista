package com.example.ProjectList.controller;


import com.example.ProjectList.model.User;
import com.example.ProjectList.repository.UserRepository;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //POST register
    @PostMapping("/register")
    public String register(@RequestBody User user){
        if(userRepository.existsByUsername(user.getUsername())){
            return "username già esistente";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ("utente registrato");
    }

    @GetMapping("/login")
    public String login(){
        return "login ok";
    }
}
