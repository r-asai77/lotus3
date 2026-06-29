package com.app.lotus.admin.inquiry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/inquiries")
public class AdminInquiryController {

    @GetMapping
    public String index() {
        return "admin/inquiry/index";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id) {
        return "admin/inquiry/detail";
    }

    @GetMapping("/checklist")
    public String checklist() {
        return "admin/inquiry/checklist";
    }
}
