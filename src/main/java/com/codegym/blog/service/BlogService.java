package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Catagory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Page<Blog> findAllByAuthorStartsWith(String author, Pageable pageable);

    Page<Blog> findAllByCatagory(Catagory catagory, Pageable pageable);

}