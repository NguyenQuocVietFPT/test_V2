package com.vietnqph20665.test_v2.service.impl;

import com.vietnqph20665.test_v2.model.sub_category;
import com.vietnqph20665.test_v2.repository.ISubCategoryRepository;
import com.vietnqph20665.test_v2.service.ISubCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class SubCateService implements ISubCateService {

    @Autowired
    private ISubCategoryRepository _subCateRepo;

    @Override
    public List<sub_category> findAll() {
        return _subCateRepo.findAll();
    }

    @Override
    public sub_category save(sub_category subCategory) {
        return _subCateRepo.save(subCategory);
    }

    @Override
    public void deleteById(Long id) {
        _subCateRepo.deleteById(id);
    }

    @Override
    public sub_category findById(Long id) {
        Optional<sub_category> opt = _subCateRepo.findById(id);

        if (opt.isPresent()) {
            return opt.get();
        }
        else return null;
    }

}
