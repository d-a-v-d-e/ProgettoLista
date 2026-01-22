package com.example.ProjectList.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String chosenName;

    @Column(nullable = false)
    private String password;

    private String role = "USER";

    public User() {}

    public User(String username, String chosenName,String password) {
        this.username = username;
        this.chosenName = chosenName;
        this.password = password;
    }

    // getter & setter
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String chosenName() { return chosenName; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
}
