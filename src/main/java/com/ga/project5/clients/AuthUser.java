package com.ga.project5.clients;

public class AuthUser {
    private Long client;
    private String userName;
    private String email;
    private Boolean isAuthorized;

    public AuthUser(Long client, String userName, String email, Boolean isAuthorized) {
        this.client = client;
        this.userName = userName;
        this.email = email;
        this.isAuthorized = isAuthorized;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
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
                "client=" + client +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", isAuthorized=" + isAuthorized +
                '}';
    }
}
