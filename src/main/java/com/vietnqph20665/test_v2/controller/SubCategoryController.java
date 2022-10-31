package com.vietnqph20665.test_v2.controller;

import com.vietnqph20665.test_v2.model.category;
import com.vietnqph20665.test_v2.model.sub_category;
import com.vietnqph20665.test_v2.service.ICategoryService;
import com.vietnqph20665.test_v2.service.ISubCateService;
import com.vietnqph20665.test_v2.service.impl.CategoryService;
import com.vietnqph20665.test_v2.service.impl.SubCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SubCategoryController {

    @Autowired
    private SubCateService _subCateService;

    @Autowired
    private CategoryService _cateService;

    @GetMapping("/subcategories")
    public String indexHome(Model model) {
        List<sub_category> sub_categories = _subCateService.findAll();
        model.addAttribute("sub_categories",sub_categories);
        return "sub_categories";
    }

    @GetMapping("/subcategories/new")
    public String openForm(Model model) {
        List<category> categories = _cateService.getAll();
        model.addAttribute("sub_category", new sub_category());
        model.addAttribute("categories",categories);
        return "new_sub_category";
    }

    @PostMapping("/subcategories/save")
    public String saveDate(sub_category subCategory) {
        _subCateService.save(subCategory);
        return "redirect:/subcategories";
    }

    @GetMapping("/subcategories/update/{id}")
    public String getData(@PathVariable("id") Long id, Model model)  {
        sub_category sub_category = _subCateService.findById(id);
        model.addAttribute("sub_category",sub_category);
        List<category> categories = _cateService.getAll();
        model.addAttribute("categories",categories);
        return "new_sub_category";
    }


    @GetMapping("/subcategories/delete/{id}")
    public String delete(@PathVariable("id") Long id,Model model) {
        _subCateService.deleteById(id);
        return "redirect:/subcategories";
    }

    @GetMapping("/subcategories/see/{id}")
    public String seeDetail(@PathVariable("id") Long id, Model model)  {
        sub_category subCategory = _subCateService.findById(id);
        model.addAttribute("subCategory",subCategory);
        List<category> categories = _cateService.getAll();
        model.addAttribute("categories",categories);
        return "see_sub_category";
    }

    @GetMapping("/subcategories/exit")
    public String exitSee(sub_category subCategory) {
        return "redirect:/subcategories";
    }



}
