package com.npci.loanApplication.entities;

public class CustomerLoginRequest {

    private String email;
    private String password;

    // Constructors, getters, and setters

    public CustomerLoginRequest() {
    }

    public CustomerLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
