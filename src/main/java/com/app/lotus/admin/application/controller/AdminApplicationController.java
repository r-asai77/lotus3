package com.app.lotus.admin.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/applications")
public class AdminApplicationController {

    @GetMapping
    public String index() {
        return "admin/application/index";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id) {
        return "admin/application/detail";
    }
}
