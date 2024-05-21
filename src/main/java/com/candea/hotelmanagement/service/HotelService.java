package com.candea.hotelmanagement.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candea.hotelmanagement.dao.HotelDao;
import com.candea.hotelmanagement.dao.HotelRoomDao;
import com.candea.hotelmanagement.entity.Hotel;
import com.candea.hotelmanagement.entity.HotelRoom;

@Service
public class HotelService {
    
    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private HotelRoomDao hotelRoomDao;

    public Hotel addHotel(Hotel hotel){
        return hotelDao.save(hotel);
    }

    public List<Hotel> getHotels(){
        List<Hotel> hotels = new ArrayList<>();
        hotelDao.findAll().forEach(hotels::add);
        return hotels;
    }

    public Hotel getHotelById(Integer id){
        return hotelDao.findById(id).orElse(null);
    }

    public List<HotelRoom> getHotelsRooms(Integer id){
        List<HotelRoom> hotelRooms = new ArrayList<>();
        Hotel hotel = hotelDao.findById(id).orElse(null);
        if(hotel != null){
            hotelRooms = hotel.getHotelRooms();
        }
        return hotelRooms;
    }

    public void deleteHotel(Integer id){
        hotelDao.deleteById(id);
    }

    public Hotel updateHotel(Hotel hotel){
        hotelDao.findById(hotel.getHotelId()).orElseThrow();
        return hotelDao.save(hotel);
    }

    public List<HotelRoom> getAvailableRooms(Integer hotelId, LocalDate checkin, LocalDate checkout){
        return hotelRoomDao.findAvailableRooms(hotelId, checkin, checkout);
    }

}
