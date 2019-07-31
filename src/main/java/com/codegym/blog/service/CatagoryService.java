package com.codegym.blog.service;

import com.codegym.blog.model.Catagory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CatagoryService {
    Page<Catagory> findAll(Pageable pageable);

    Catagory findById(Long id);

    void save(Catagory catagory);

    void remove(Long id);
}