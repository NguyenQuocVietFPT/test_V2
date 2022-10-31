package com.vietnqph20665.test_v2.controller;

import com.vietnqph20665.test_v2.model.brand;
import com.vietnqph20665.test_v2.model.product;
import com.vietnqph20665.test_v2.model.status;
import com.vietnqph20665.test_v2.model.sub_category;
import com.vietnqph20665.test_v2.service.impl.BrandService;
import com.vietnqph20665.test_v2.service.impl.ProductService;
import com.vietnqph20665.test_v2.service.impl.StatusService;
import com.vietnqph20665.test_v2.service.impl.SubCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService _productService;

    @Autowired
    private BrandService _brandService;

    @Autowired
    private SubCateService _subCateService;

    @Autowired
    private StatusService _statusService;

    @GetMapping("/products")
    public String indexPage(Model model) {

        List<product> products = _productService.findAll();
        model.addAttribute("products", products);
        return "products";

    }

    @GetMapping("/products/new")
    public String openForm(Model model) {

        List<sub_category> subcategories = _subCateService.findAll();
        List<status> statuses = _statusService.findAll();
        List<brand> brandList = _brandService.findAll();
        model.addAttribute("subcategories",subcategories);
        model.addAttribute("statuses",statuses);
        model.addAttribute("brandList",brandList);
        model.addAttribute("product", new product());

        return "new_product";

    }

    @PostMapping("/products/save")
    public String saveOrUpdate(product product) {

        _productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/products/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, Model model) {

        List<sub_category> subcategories = _subCateService.findAll();
        List<status> statuses = _statusService.findAll();
        List<brand> brandList = _brandService.findAll();
        product product = _productService.findById(id);
        model.addAttribute("subcategories",subcategories);
        model.addAttribute("statuses",statuses);
        model.addAttribute("brandList",brandList);
        model.addAttribute("product", product);

        return "new_product";
    }


    @GetMapping("/products/see/{id}")
    public String detailProduct(@PathVariable("id") Long id, Model model) {

        List<sub_category> subcategories = _subCateService.findAll();
        List<status> statuses = _statusService.findAll();
        List<brand> brandList = _brandService.findAll();
        product product = _productService.findById(id);
        model.addAttribute("subcategories",subcategories);
        model.addAttribute("statuses",statuses);
        model.addAttribute("brandList",brandList);
        model.addAttribute("product", product);

        return "see_product";
    }

    @GetMapping("products/exit")
    public String exitDetail(product pro) {
        return "redirect:/products";
    }




}
