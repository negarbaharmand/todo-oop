package com.baharmand.model;

import java.util.Objects;

public class AppUser {
    private String userName;
    private String passWord;
    private AppRole role;

    public AppUser(String userName, String passWord, AppRole role) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public AppRole getRole() {
        return role;
    }

    public void setUserName(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        if (passWord == null || passWord.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }
        this.passWord = passWord;
    }

    public void setRole(AppRole role) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null or empty.");
        }
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(userName, appUser.userName) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, role);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userName='" + userName + '\'' +
                ", role=" + role +
                '}';
    }
}
