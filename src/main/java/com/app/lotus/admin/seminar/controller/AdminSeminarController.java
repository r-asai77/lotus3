package com.app.lotus.admin.seminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/seminars")
public class AdminSeminarController {

    @GetMapping({"", "/"})
    public String index() {
        return "admin/seminar/index";
    }

    @GetMapping("/entries")
    public String entries() {
        return "admin/seminar/entries";
    }

    @GetMapping("/passed")
    public String passed() {
        return "admin/seminar/passed";
    }

    @GetMapping("/schedules")
    public String schedules() {
        return "admin/seminar/schedules";
    }
}
