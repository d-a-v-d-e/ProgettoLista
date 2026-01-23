package com.example.ProjectList.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id

    @Column(unique = true, nullable = false)
    private String username;

    private String nickname;

    @Column(nullable = false)
    private String password;

    private String role = "USER";

    public User() {}

    public User(String username, String nickname, String password, String role) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
    }

    // getter & setter
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getNickname() { return nickname; }
    public void setNickname(String chosenName) { this.nickname = chosenName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
