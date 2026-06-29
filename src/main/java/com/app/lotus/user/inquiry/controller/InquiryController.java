package com.app.lotus.user.inquiry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

    @GetMapping
    public String index() {
        return "user/inquiry/index";
    }

    @GetMapping("/new")
    public String newForm() {
        return "user/inquiry/new";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id) {
        return "user/inquiry/detail";
    }
}
