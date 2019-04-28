package com.merveakgormus.gyk_note_app.model;

public class User {
    private String username;
    private String surname;
    private String email;

    public User(String username, String surname, String email) {
        this.username = username;
        this.surname = surname;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
