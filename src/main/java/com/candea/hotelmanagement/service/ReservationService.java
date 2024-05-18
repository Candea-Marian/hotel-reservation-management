package com.candea.hotelmanagement.service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.candea.hotelmanagement.dao.ReservationDao;
import com.candea.hotelmanagement.entity.Reservation;

public class ReservationService {
    @Autowired
    private ReservationDao reservationDao;

    public Reservation addReservation(Reservation reservation){
        return reservationDao.save(reservation);
    }

    public Reservation getReservationById(Integer id){
        return reservationDao.findById(id).orElse(null);
    }

    public void deleteReservation(Integer id){
        reservationDao.deleteById(id);
    }

    public Reservation updateReservation(Reservation reservation){
        reservationDao.findById(reservation.getReservationId()).orElseThrow();
        return reservationDao.save(reservation);
    }
    
}
