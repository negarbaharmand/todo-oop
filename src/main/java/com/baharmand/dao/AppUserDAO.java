package com.baharmand.dao;

import com.baharmand.AppUser;

import java.util.Collection;

public interface AppUserDAO {
    void persist(AppUser appUser);
    AppUser findByUsername(String username);
    Collection<AppUser> findAll();
    void remove(String username);
}
