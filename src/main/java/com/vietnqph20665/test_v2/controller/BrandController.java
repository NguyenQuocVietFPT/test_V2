package com.vietnqph20665.test_v2.controller;

import com.vietnqph20665.test_v2.model.brand;
import com.vietnqph20665.test_v2.service.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandService _brandService;

    @GetMapping("/brands")
    public String getIndex(Model model) {

        List<brand> brands = _brandService.findAll();
        model.addAttribute("brands",brands);
        return "brands";

    }

    @GetMapping("/brands/new")
    public String openFormNew(Model model) {

        model.addAttribute("brand", new brand());
        return "new_brand";
    }

    @PostMapping("/brands/save")
    public String saveBrand(brand brand) {

        _brandService.save(brand);

        return "redirect:/brands";
    }

    @GetMapping("/brands/see/{id}")
    public String showDate(@PathVariable("id") Long id, Model model) {

        brand brand = _brandService.findById(id);
        model.addAttribute("brand", brand);

        return "see_brand";
    }

    @GetMapping("/brands/exit")
    public String openFormNew(brand brand) {

        return "redirect:/brands";
    }

    @GetMapping("/brands/delete/{id}")
    public String deleteBrand(@PathVariable("id") Long id) {

        _brandService.deleteById(id);
        return "redirect:/brands";

    }

    @GetMapping("/brands/update/{id}")
    public String openDate(@PathVariable("id") Long id, Model model) {

        brand brand =  _brandService.findById(id);
        model.addAttribute("brand", brand);

        return "new_brand";

    }

}
