package com.vietnqph20665.test_v2.service.impl;

import com.vietnqph20665.test_v2.model.status;
import com.vietnqph20665.test_v2.repository.IStatusRepository;
import com.vietnqph20665.test_v2.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService implements IStatusService {

    @Autowired
    private IStatusRepository _statusRepo;

    @Override
    public List<status> findAll() {
        return _statusRepo.findAll();
    }

    @Override
    public status save(status sta) {
        return _statusRepo.save(sta);
    }

    @Override
    public status findById(Long id) {

        Optional<status> opt = _statusRepo.findById(id);

        if (opt.isPresent()) {
            return opt.get();
        } else return null;
    }

    @Override
    public void deleteById(Long id) {
        _statusRepo.deleteById(id);
    }
}
