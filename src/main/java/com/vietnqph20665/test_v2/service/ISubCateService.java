package com.vietnqph20665.test_v2.service;

import com.vietnqph20665.test_v2.model.sub_category;

import java.util.List;

public interface ISubCateService {

    List<sub_category> findAll();

    sub_category save(sub_category subCategory);

    void deleteById(Long id);

    sub_category findById(Long id);

}
