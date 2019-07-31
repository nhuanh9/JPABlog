package com.codegym.blog.repository;

import com.codegym.blog.model.Catagory;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CatagoryRepository extends PagingAndSortingRepository<Catagory, Long> {
}