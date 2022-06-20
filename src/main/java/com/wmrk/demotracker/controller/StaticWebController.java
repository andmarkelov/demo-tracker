package com.wmrk.demotracker.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticWebController {

    @GetMapping({"/", "/index", "/reg", "/logout", "/settings"})
    public String vueApp(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("spring_username", currentUser != null ? currentUser.getUsername() : "");

        return "vue-app";
    }

    @GetMapping("/auth")
    public String login() {
        return "vue-app";
    }

}
