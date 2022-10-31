package com.vietnqph20665.test_v2.controller;

import com.vietnqph20665.test_v2.model.category;
import com.vietnqph20665.test_v2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService _cateService;

    @GetMapping("/categories")
    public String getList(Model model) {

        List<category> categories = _cateService.getAll();
        model.addAttribute("categories",categories);

        return "categories";
    }

    @GetMapping("/categories/new")
    public String getForm(Model model){
        model.addAttribute("category", new category());
        return "new_category";
    }

    @PostMapping("/categories/save")
    public String saveOrUpdate(category category) {
        _cateService.save(category);
        return "redirect:/home";
    }

    @GetMapping("/categories/delete/{id}")
    public String delete(@PathVariable("id") Long id,Model model) {

        _cateService.deleteById(id);

        return "redirect:/categories";
    }

    @GetMapping("/categories/see/{id}")
    public String see(@PathVariable("id") Long id, Model model) {

        category category = _cateService.findById(id);

        model.addAttribute("category", category);

        return "see_category";
    }

    @GetMapping("/categories/exit")
    public String exit(category category) {

        return "redirect:/categories";
    }
}

