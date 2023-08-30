package com.baharmand.dao;

import com.baharmand.model.AppUser;

public interface AppUserDAO extends BaseDAO<AppUser, String> {
    AppUser findByUsername(String username);
}
