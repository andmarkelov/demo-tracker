package com.wmrk.demotracker.controller;


import com.fasterxml.jackson.core.io.JsonStringEncoder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StaticWebController {

    
    @GetMapping({"/", "/index"})
    public String index() {
        return "index.html";
    }



    @GetMapping({"/manage", "/reg", "/logout"})
    public String vueApp(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("spring_username", currentUser != null ? currentUser.getUsername() : "");

        return "vue-app";
    }



    @RequestMapping(value = "/auth",
            produces = "text/html",
            method = {RequestMethod.GET, RequestMethod.POST})

    public String login(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("spring_username", currentUser != null ? currentUser.getUsername() : "");

        return "vue-app";
    }

//    @PostMapping("/login")
//    @CrossOrigin(origins = "*")
//    public String manage2(@AuthenticationPrincipal User currentUser, Model model) {
//        model.addAttribute("spring_username", currentUser != null ? currentUser.getUsername() : "");
//
//        return "vue-app";
//    }
    
}
