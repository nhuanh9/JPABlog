package com.codegym.blog.service.impl;

import com.codegym.blog.model.Catagory;
import com.codegym.blog.repository.CatagoryRepository;
import com.codegym.blog.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CatagoryServiceImpl implements CatagoryService {

    @Autowired
    private CatagoryRepository catagoryRepository;

    @Override
    public Page<Catagory> findAll(Pageable pageable) {
        return catagoryRepository.findAll(pageable);
    }

    @Override
    public Catagory findById(Long id) {
        return catagoryRepository.findOne(id);
    }

    @Override
    public void save(Catagory catagory) {
        catagoryRepository.save(catagory);
    }

    @Override
    public void remove(Long id) {
        catagoryRepository.delete(id);
    }
}