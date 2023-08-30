package com.baharmand.dao;

import com.baharmand.model.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDAOCollection implements AppUserDAO {
    private List<AppUser> appUsers = new ArrayList<>();

    @Override
    public void persist(AppUser appUser) {

        appUsers.add(appUser);
    }

    @Override
    public AppUser findByUsername(String username) {
        for (AppUser appUser : appUsers) {
            if (appUser.getUserName().equals(username)) {
                return appUser;
            }
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return new ArrayList<>(appUsers);
    }

    @Override
    public void remove(String username) {
        AppUser appUserToRemove = findByUsername(username);
        if (appUserToRemove != null) {
            appUsers.remove(appUserToRemove);
        }
    }
}
