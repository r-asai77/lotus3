package com.app.lotus.admin.notification.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/notification")
public class AdminNotificationController {

    @GetMapping({"", "/"})
    public String index() {
        return "admin/notification/index";
    }
}
