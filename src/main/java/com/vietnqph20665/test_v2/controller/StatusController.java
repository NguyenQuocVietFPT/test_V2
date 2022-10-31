package com.vietnqph20665.test_v2.controller;

import com.vietnqph20665.test_v2.model.status;
import com.vietnqph20665.test_v2.service.impl.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StatusController {

    @Autowired
    private StatusService _statusService;

    @GetMapping("/statuses")
    public String indexPage(Model model) {

        List<status> statuses = _statusService.findAll();
        model.addAttribute("statuses",statuses);

        return "statuses";
    }

    @GetMapping("/statuses/new")
    public String openForm(Model  model) {

        model.addAttribute("status", new status());
        return "new_status";

    }

    @PostMapping("/statuses/save")
    public String addStatus(status sta) {

        _statusService.save(sta);
        return "redirect:/statuses";
    }
}
