package com.candea.hotelmanagement.dao;

import com.candea.hotelmanagement.entity.HotelRoom;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelRoomDao extends JpaRepository<HotelRoom, Integer>{

     @Query("SELECT r FROM HotelRoom r WHERE r.hotel.hotelId = :hotelId AND r.roomNumber NOT IN " +
           "(SELECT res.room.roomNumber FROM Reservation res WHERE " +
           "(res.checkInDate < :checkout AND res.checkOutDate > :checkin))")
    List<HotelRoom> findAvailableRooms(@Param("hotelId") Integer hotelId, @Param("checkin") LocalDate checkin, @Param("checkout") LocalDate checkout);
    
}
