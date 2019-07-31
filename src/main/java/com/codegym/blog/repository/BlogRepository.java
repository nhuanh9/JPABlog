package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Catagory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByAuthorStartsWith(String author, Pageable pageable);

    Page<Blog> findAllByCatagory(Catagory catagory, Pageable pageable);
}