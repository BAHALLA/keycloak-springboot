package org.sid.controllers;

import org.sid.dao.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("/categories")
    public String allCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories";
    }
}
