package com.app.lotus.user.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping
    public String profile() {
        return "user/account/profile";
    }

    @GetMapping("/billing")
    public String billing() {
        return "user/account/billing";
    }

    @GetMapping("/qualifications")
    public String qualifications() {
        return "user/account/qualifications";
    }
}
