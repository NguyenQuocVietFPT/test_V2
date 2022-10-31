package com.vietnqph20665.test_v2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.annotation.WebServlet;

@Controller
public class HomePageController {

    @GetMapping("/home")
    public String getHome() {

        return "index";
    }


}
