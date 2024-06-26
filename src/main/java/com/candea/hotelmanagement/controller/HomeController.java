package com.candea.hotelmanagement.controller;

import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("/rooms/{hotelId}")
    public String hotelRooms(@PathVariable Integer hotelId) {
        //got an alternative way to get hotelId and roomId, hope you don't mind
        return "hotel-rooms";
    }

    @GetMapping("/make-reservation/{hotelId}/{roomId}")
    public String makeReservation(@PathVariable Integer hotelId,@PathVariable Integer roomId, Model model) {
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("roomId", roomId);
        return "make-reservation";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin(){
        return "Welcome Admin";
    }
    
}
