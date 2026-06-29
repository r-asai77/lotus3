package com.app.lotus.admin.qualification.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/qualifications")
public class AdminQualificationController {

    @GetMapping("/master")
    public String master() {
        return "admin/qualification/master";
    }

}
