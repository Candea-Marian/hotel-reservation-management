package com.candea.hotelmanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@ManyToOne
    //@JoinColumn(name = "hotel_id")
    private Integer hotelId;

    //@ManyToOne
    //@JoinColumn(name = "room_id")
    private Integer roomId;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    //@ManyToOne
    //@JoinColumn(name = "user_id")
    private Integer userId;

    public Reservation() {
    }

    public Reservation(Integer hotelId, Integer roomId, LocalDate checkInDate, LocalDate checkOutDate, Integer userId) {
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.userId = userId;
    }

    public Integer getReservationId() {
        return id;
    }

    public void setReservationId(Integer reservationId) {
        this.id = reservationId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    
    
    
}
