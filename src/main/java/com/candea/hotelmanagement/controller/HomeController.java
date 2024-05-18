package com.candea.hotelmanagement.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping({"/","/home","/index.html"})
    public String home(){
        return "index";
    }

    //@PreAuthorize("hasRole('USER')")
    @GetMapping("/all")
    public String allHotels(){
        return "all-hotels";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin(){
        return "Welcome Admin";
    }
    
}
