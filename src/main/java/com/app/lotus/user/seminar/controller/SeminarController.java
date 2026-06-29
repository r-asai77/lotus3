package com.app.lotus.user.seminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seminar")
public class SeminarController {

    @GetMapping
    public String index() {
        return "user/seminar/index";
    }

    @GetMapping("/cart")
    public String cart() {
        return "user/seminar/cart";
    }

    @GetMapping("/confirm")
    public String confirm() {
        return "user/seminar/confirm";
    }

    @GetMapping("/complete")
    public String complete() {
        return "user/seminar/complete";
    }
}
