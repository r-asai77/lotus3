package com.app.lotus.user.auth.controller;

import com.app.lotus.user.auth.exception.DuplicateLoginIdException;
import com.app.lotus.user.auth.form.RegisterForm;
import com.app.lotus.user.auth.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserAuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "user/auth/login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "user/auth/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute RegisterForm form,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "user/auth/register";
        }
        try {
            userService.register(form);
        } catch (DuplicateLoginIdException e) {
            result.rejectValue("loginId", "duplicate", e.getMessage());
            return "user/auth/register";
        }
        return "redirect:/login?registered";
    }
}
