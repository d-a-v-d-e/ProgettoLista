package com.example.ProjectList.service;

import com.example.ProjectList.model.User;
import com.example.ProjectList.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String username, String chosenName, String password){
        if(userRepository.findByUsername(username).isPresent()){
            throw new RuntimeException("Utente esistente");
        }

        User user = new User(
                username,
                chosenName,
                passwordEncoder.encode(password)
        );

        return userRepository.save(user);
    }
}
