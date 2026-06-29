package com.app.lotus.admin.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/information")
public class AdminInformationController {

    @GetMapping({"", "/"})
    public String index() {
        return "admin/information/index";
    }

    @GetMapping("/new")
    public String newForm() {
        return "admin/information/new";
    }

    @GetMapping("/checklist")
    public String checklist() {
        return "admin/information/checklist";
    }

    @GetMapping("/master")
    public String master() {
        return "admin/information/master";
    }
}
