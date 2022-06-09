package com.wmrk.demotracker.controller;


import org.springframework.stereotype.Controller;
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
    public String manage() {
        return "manage";
    }
    
}
