package com.candea.hotelmanagement.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candea.hotelmanagement.dao.ReservationDao;
import com.candea.hotelmanagement.entity.Reservation;
import com.candea.hotelmanagement.exception.InvalidReservationException;
import com.candea.hotelmanagement.util.SecurityUtils;

@Service
public class ReservationService {
    @Autowired
    private ReservationDao reservationDao;

    public Reservation addReservation(Reservation reservation){
        if (reservation == null) {
            throw new InvalidReservationException("Reservation cannot be null");
        }

        if (reservation.getCheckInDate() == null || reservation.getCheckOutDate() == null) {
            throw new InvalidReservationException("Check-in and check-out dates must be provided");
        }

        if (reservation.getCheckInDate().isAfter(reservation.getCheckOutDate())) {
            throw new InvalidReservationException("Check-in date must be before check-out date");
        }

        if (reservation.getCheckInDate().isBefore(LocalDate.now())) {
            throw new InvalidReservationException("Check-in date must be in the future");
        }

        if (reservation.getHotelId() == null || reservation.getRoomId() == null || reservation.getUserId() == null) {
            throw new InvalidReservationException("Hotel ID, room ID, and user ID must be provided");
        }


        return reservationDao.save(reservation);
    }

    public Reservation getReservationById(Integer id){

        if(id == null){
            throw new InvalidReservationException("Id must be provided");
        }

        if(id < 0){
            throw new InvalidReservationException("Id must be positive");
        }

        if(!reservationDao.existsById(id)){
            throw new InvalidReservationException("Reservation with id " + id + " not found");
        }

        return reservationDao.findById(id).orElse(null);
    }

    public void deleteReservation(Integer id){

        if(id == null){
            throw new InvalidReservationException("Id must be provided");
        }

        if(id < 0){
            throw new InvalidReservationException("Id must be positive");
        }

        if(!reservationDao.existsById(id)){
            throw new InvalidReservationException("Reservation with id " + id + " not found");
        }
        

        reservationDao.deleteById(id);
    }

    public Reservation updateReservation(Reservation reservation){
        reservationDao.findById(reservation.getReservationId()).orElseThrow();

        if (reservation.getCheckInDate().isAfter(reservation.getCheckOutDate())) {
            throw new InvalidReservationException("Check in date must be before check out date");
        }

        if(reservation.getHotelId() == null || reservation.getRoomId() == null || reservation.getUserId() == null){
            throw new InvalidReservationException("Hotel id, room id and user id must be provided");
        }

        if(reservation.getCheckInDate() == null || reservation.getCheckOutDate() == null){
            throw new InvalidReservationException("Check in and check out date must be provided");
        }

        if(reservation.getCheckInDate().isBefore(LocalDate.now())){
            throw new InvalidReservationException("Check in date must be in the future");
        }

        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();

        // Calculate the check-in date and time
        LocalDateTime checkInDateTime = reservation.getCheckInDate().atStartOfDay();

        // Calculate the difference in seconds between the current time and check-in time
        long secondsUntilCheckIn = Duration.between(currentTime, checkInDateTime).getSeconds();

        // If the update is within 2 hours of the check-in time, throw an exception
        if (secondsUntilCheckIn < 2 * 60 * 60) {
            throw new InvalidReservationException("Reservation cannot be updated within 2 hours of check-in date");
        }

        return reservationDao.save(reservation);
    }

    public List<Reservation> getReservationsByUserId(){

        Integer userId = SecurityUtils.getCurrentUserId();

        return reservationDao.findByUserId(userId);
    }
    
}
