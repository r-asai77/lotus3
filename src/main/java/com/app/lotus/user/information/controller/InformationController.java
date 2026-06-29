package com.app.lotus.user.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/information")
public class InformationController {

    @GetMapping
    public String index() {
        return "user/information/index";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id) {
        return "user/information/detail";
    }
}
