package com.candea.hotelmanagement.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.candea.hotelmanagement.entity.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Integer>{
    
    public List<Reservation> findByUserId(Integer userId);
}
