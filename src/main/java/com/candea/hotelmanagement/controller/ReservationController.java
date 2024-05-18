package com.candea.hotelmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.candea.hotelmanagement.dao.ReservationDao;
import com.candea.hotelmanagement.entity.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//reservation controller 
//it needs the hotel and room id to make a reservation
//it needs the check in and check out date
//it needs the user id

@RestController
public class ReservationController {

    @Autowired
    private ReservationDao reservationDao;

    @PostMapping("/add/reservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationDao.save(reservation);
    }

    @GetMapping("/get/reservation/{id}")
    public Reservation getReservationById(@PathVariable Integer id) {
        return reservationDao.findById(id).orElse(null);
    }

    @DeleteMapping("/delete/reservation/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationDao.deleteById(id);
    }

    @PutMapping("update/reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        reservationDao.findById(reservation.getReservationId()).orElseThrow();
        return reservationDao.save(reservation);
    }
}