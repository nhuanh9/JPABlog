package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Catagory;
import com.codegym.blog.repository.BlogRepository;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.delete(id);
    }

    @Override
    public Page<Blog> findAllByAuthorStartsWith(String author, Pageable pageable) {
        return blogRepository.findAllByAuthorStartsWith(author, pageable);
    }

    @Override
    public Page<Blog> findAllByCatagory(Catagory catagory, Pageable pageable) {
        return blogRepository.findAllByCatagory(catagory, pageable);
    }
}
