package com.app.lotus.admin.auth.controller;

import com.app.lotus.admin.auth.exception.DuplicateAdminLoginIdException;
import com.app.lotus.admin.auth.form.AdminRegisterForm;
import com.app.lotus.admin.auth.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminAuthController {

    private final AdminService adminService;

    @GetMapping("/login")
    public String login() {
        return "admin/auth/login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("form", new AdminRegisterForm());
        return "admin/auth/register";
    }

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("form") AdminRegisterForm form,
            BindingResult result) {
        if (result.hasErrors()) {
            return "admin/auth/register";
        }
        try {
            adminService.register(form);
        } catch (DuplicateAdminLoginIdException e) {
            result.rejectValue("loginId", "duplicate", e.getMessage());
            return "admin/auth/register";
        }
        return "redirect:/admin/login?registered";
    }
}
