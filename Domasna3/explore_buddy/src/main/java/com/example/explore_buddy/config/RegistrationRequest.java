package com.example.explore_buddy.config;

import com.example.explore_buddy.model.enumeration.UserRole;

public class RegistrationRequest {

    private final String email;
    private final String password;
    private final UserRole role;

    public RegistrationRequest(String email, String password, UserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}