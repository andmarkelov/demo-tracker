package com.wmrk.demotracker.controller;


import com.fasterxml.jackson.core.io.JsonStringEncoder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticWebController {

    
    @GetMapping({"/", "/index"})
    @CrossOrigin(origins = "*")
    public String index() {
        //long count = geoPointRepo.count();
        return "index.html";
    }

    @GetMapping("/map")
    public String map() {
        return "map.html";
    }

    @GetMapping("/manage")
    @CrossOrigin(origins = "*")
    public String manage(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("spring_username", currentUser.getUsername());
        return "manage";
    }
    
}
