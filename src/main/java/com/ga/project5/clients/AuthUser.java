package com.ga.project5.clients;

public class AuthUser {
    private String userName;
    private String email;
    private Boolean isAuthorized;

    public AuthUser(String userName, String email, Boolean isAuthorized) {
        this.userName = userName;
        this.email = email;
        this.isAuthorized = isAuthorized;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(Boolean authorized) {
        isAuthorized = authorized;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", isAuthorized=" + isAuthorized +
                '}';
    }
}
