package com.candea.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.candea.hotelmanagement.entity.Hotel;
import com.candea.hotelmanagement.entity.HotelRoom;
import com.candea.hotelmanagement.service.HotelService;

@RestController
public class HotelController {
    
    @Autowired
    private HotelService hotelService;

    @PostMapping("/addHotel")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    @GetMapping("/get/hotel")
    public List<Hotel> getHotels(){
        return hotelService.getHotels();
    }

    @GetMapping("/get/hotel/{id}/rooms")
    public List<HotelRoom> getHotelRooms(@PathVariable Integer id){
        return hotelService.getHotelsRooms(id);
    }

    @GetMapping("/get/hotel/{id}")
    public Hotel getHotelById(@PathVariable Integer id){
        return hotelService.getHotelById(id);
    }

    @DeleteMapping("/delete/hotel/{id}")
    public void deleteHotel(@PathVariable Integer id){
        hotelService.deleteHotel(id);
    }

    @PutMapping("/update/hotel")
    public Hotel updateHotel(@RequestBody Hotel hotel){
        return hotelService.updateHotel(hotel);
    }

}
