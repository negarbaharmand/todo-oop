package com.baharmand.dao;

import com.baharmand.model.Person;

public interface PersonDAO extends BaseDAO<PersonDAO, Integer> {
    Person findById(int id);
    Person findByEmail(String email);
}
