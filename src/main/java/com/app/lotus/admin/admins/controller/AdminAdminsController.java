package com.app.lotus.admin.admins.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/admins")
public class AdminAdminsController {

    @GetMapping({"", "/"})
    public String index() {
        return "admin/admins/index";
    }

    @GetMapping("/permissions")
    public String permissions() {
        return "admin/admins/permissions";
    }
}
