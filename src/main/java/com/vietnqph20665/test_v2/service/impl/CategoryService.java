package com.vietnqph20665.test_v2.service.impl;

import com.vietnqph20665.test_v2.model.category;
import com.vietnqph20665.test_v2.repository.ICategoryRepository;
import com.vietnqph20665.test_v2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository _cateRepo;

    @Override
    public List<category> getAll() {

        return _cateRepo.findAll();
    }

    @Override
    public category save(category cate) {
        return _cateRepo.save(cate);
    }

    @Override
    public category findById(Long id) {

        Optional<category> opt = _cateRepo.findById(id);

        if (opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {

        _cateRepo.deleteById(id);

    }
}
