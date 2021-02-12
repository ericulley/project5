package com.ga.project5.clients;

import javax.persistence.*;

@Entity
@Table
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;

//  Constructor 1: None
    public Session() {
    }
// Constructor 2: All
    public Session(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
// Constructor 3: No id for DB
    public Session(String email, String password) {
        this.email = email;
        this.password = password;
    }

//  Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
