package com.vietnqph20665.test_v2.service;

import java.util.List;

public interface IGenericService<T> {

    List<T> findAll();

    T save(T t);

    T findById(Long id);

    void deleteById(Long id);

}
