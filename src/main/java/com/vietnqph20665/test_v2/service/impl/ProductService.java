package com.vietnqph20665.test_v2.service.impl;

import com.vietnqph20665.test_v2.model.product;
import com.vietnqph20665.test_v2.repository.IProductRepository;
import com.vietnqph20665.test_v2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository _productRepo;

    @Override
    public List<product> findAll() {
        return _productRepo.findAll();
    }

    @Override
    public product save(product product) {
        return _productRepo.save(product);
    }

    @Override
    public product findById(Long id) {
        Optional<product> opt = _productRepo.findById(id);

        if (opt.isPresent()) {
            return opt.get();
        }
        else return null;
    }

    @Override
    public void deleteById(Long id) {
        _productRepo.deleteById(id);
    }
}
