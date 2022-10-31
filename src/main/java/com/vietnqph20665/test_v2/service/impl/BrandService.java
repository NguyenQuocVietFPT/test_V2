package com.vietnqph20665.test_v2.service.impl;

import com.vietnqph20665.test_v2.model.brand;
import com.vietnqph20665.test_v2.repository.IBrandRepository;
import com.vietnqph20665.test_v2.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService implements IBrandService {

    @Autowired
    private IBrandRepository _brandRepo;

    @Override
    public List<brand> findAll() {
        return _brandRepo.findAll();
    }

    @Override
    public brand save(brand brand) {
        return _brandRepo.save(brand);
    }

    @Override
    public brand findById(Long id) {

        Optional<brand> opt = _brandRepo.findById(id);

        if (opt.isPresent()) {
            return opt.get();
        } else return null;
    }

    @Override
    public void deleteById(Long id) {
        _brandRepo.deleteById(id);
    }
}
