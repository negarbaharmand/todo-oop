package com.baharmand.dao;

import java.util.Collection;

public interface BaseDAO<T, ID> {
    void persist(T t);
    void remove(ID id);
    Collection<T> findAll();
}
