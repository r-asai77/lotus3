package com.app.lotus.admin.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    @GetMapping
    public String index() {
        return "admin/user/index";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id) {
        return "admin/user/detail";
    }

    @GetMapping("/qualifications")
    public String qualifications() {
        return "admin/user/qualifications";
    }
}
