package com.example.ProjectList.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id

    @Column(unique = true, nullable = false)
    private String username;

    private String chosenName;

    @Column(nullable = false)
    private String password;

    private String role = "USER";

    public User() {}

    public User(String username, String chosenName,String password, String role) {
        this.username = username;
        this.chosenName = chosenName;
        this.password = password;
        this.role = role;
    }

    // getter & setter
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getChosenName() { return chosenName; }
    public void setChosenName(String chosenName) { this.chosenName = chosenName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
