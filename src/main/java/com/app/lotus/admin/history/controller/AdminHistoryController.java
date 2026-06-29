package com.app.lotus.admin.history.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/history")
public class AdminHistoryController {

    @GetMapping({"", "/"})
    public String index() {
        return "admin/history/index";
    }
}
