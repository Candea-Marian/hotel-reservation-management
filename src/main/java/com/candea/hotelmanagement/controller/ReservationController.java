package com.candea.hotelmanagement.controller;

import org.springframework.stereotype.Controller;

import com.candea.hotelmanagement.dao.ReservationDao;
import com.candea.hotelmanagement.entity.Reservation;
import com.candea.hotelmanagement.service.ReservationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add/reservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/get/reservation/{id}")
    public Reservation getReservationById(@PathVariable Integer id) {
        return reservationService.getReservationById(id);
    }

    @DeleteMapping("/delete/reservation/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
    }

    @PutMapping("update/reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("/get/user/reservations")
    public List<Reservation> getReservationsByUserId() {
        return reservationService.getReservationsByUserId();
    }
}