package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Catagory;
import com.codegym.blog.service.BlogService;
import com.codegym.blog.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CatagoryController {
    @Autowired
    private CatagoryService catagoryService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/catagories")
    public ModelAndView listCatagory(Pageable pageable) {
        Page<Catagory> catagories = catagoryService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/catagory/list");
        modelAndView.addObject("catagories", catagories);
        return modelAndView;
    }

    @GetMapping("/create-catagory")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/catagory/create");
        modelAndView.addObject("catagory", new Catagory());
        return modelAndView;
    }

    @PostMapping("/create-catagory")
    public ModelAndView saveCatagory(@ModelAttribute("catagory") Catagory catagory) {
        catagoryService.save(catagory);

        ModelAndView modelAndView = new ModelAndView("/catagory/create");
        modelAndView.addObject("catagory", catagory);
        modelAndView.addObject("message", "Created new catagory successfully");
        return modelAndView;
    }

    @GetMapping("/edit-catagory/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Catagory catagory = catagoryService.findById(id);
        if (catagory != null) {
            ModelAndView modelAndView = new ModelAndView("/catagory/edit");
            modelAndView.addObject("catagory", catagory);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-catagory")
    public ModelAndView updateCatagory(@ModelAttribute("catagory") Catagory catagory) {
        catagoryService.save(catagory);
        ModelAndView modelAndView = new ModelAndView("/catagory/edit");
        modelAndView.addObject("catagory", catagory);
        modelAndView.addObject("message", "Updated catagory information successfully");
        return modelAndView;
    }

    @GetMapping("/delete-catagory/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Catagory catagory = catagoryService.findById(id);
        if (catagory != null) {
            ModelAndView modelAndView = new ModelAndView("/catagory/delete");
            modelAndView.addObject("catagory", catagory);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView(("/error-404"));
            return modelAndView;
        }
    }

    @PostMapping("/delete-catagory")
    public String deleteCatagory(@ModelAttribute("catagory") Catagory catagory) {
        catagoryService.remove(catagory.getId());
        return "redirect:catagories";
    }

    @GetMapping("/view-catagory/{id}")
    public ModelAndView viewCatagory(@PathVariable("id") Long id, Pageable pageable) {
        Catagory catagory = catagoryService.findById(id);
        if (catagory == null) {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
        Page<Blog> blogs = blogService.findAllByCatagory(catagory, pageable);
        ModelAndView modelAndView = new ModelAndView("/catagory/view");
        modelAndView.addObject("catagory", catagory);
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
}