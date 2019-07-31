package com.codegym.blog.formatter;

import com.codegym.blog.model.Catagory;
import com.codegym.blog.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CatagoryFormatter implements Formatter<Catagory> {
    private CatagoryService catagoryService;

    @Autowired
    public CatagoryFormatter(CatagoryService catagoryService) {
        this.catagoryService = catagoryService;
    }

    @Override
    public Catagory parse(String text, Locale locale) throws ParseException {
        return catagoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Catagory object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}