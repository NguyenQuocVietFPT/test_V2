package com.vietnqph20665.test_v2.service;

import com.vietnqph20665.test_v2.model.category;

import java.util.List;

public interface ICategoryService {

    List<category> getAll();

    category save(category cate);

    category findById(Long id);

    void deleteById(Long id);
}
