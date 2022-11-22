package com.example.demojsp.controller;

import com.example.demojsp.config.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping({"","/"})
    public String adminHome(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("name", userDetails.getUsername());
        return "admin_home";
    }

    @GetMapping("/sc")
    public String adminHomeSc(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("name", userDetails.getUsername());
        model.addAttribute("pageTitle", "SC Admin page");
        return "admin_home";
    }
}
