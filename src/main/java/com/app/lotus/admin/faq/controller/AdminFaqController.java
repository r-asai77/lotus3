package com.app.lotus.admin.faq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/faq")
public class AdminFaqController {

    @GetMapping
    public String index() {
        return "admin/faq/index";
    }

    @GetMapping("/new")
    public String newForm() {
        return "admin/faq/new";
    }

    @GetMapping("/checklist")
    public String checklist() {
        return "admin/faq/checklist";
    }

    @GetMapping("/master")
    public String master() {
        return "admin/faq/master";
    }
}
