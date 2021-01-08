package com.example.demo.service;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(Long id);

    T save(T t);

    void delete(T t);
}
