package com.app.lotus.user.top.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {

    @GetMapping("/")
    public String index() {
        return "user/top/index";
    }
}
