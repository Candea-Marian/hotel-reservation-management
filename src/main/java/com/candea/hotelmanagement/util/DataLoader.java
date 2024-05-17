package com.candea.hotelmanagement.util;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.candea.hotelmanagement.dao.HotelDao;
import com.candea.hotelmanagement.entity.Hotel;
import com.candea.hotelmanagement.entity.HotelRoom;
import com.fasterxml.jackson.databind.ObjectMapper;

import aj.org.objectweb.asm.Type;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;


//load hotel data from json file

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private HotelDao hotelDao;
    
    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Hotel>> typeReference = new TypeReference<List<Hotel>>(){};
        InputStream inputStream = Type.class.getResourceAsStream("/hotels.json");
        try {
            List<Hotel> hotels = mapper.readValue(inputStream, typeReference);
            for (Hotel hotel : hotels) {
                for (HotelRoom room : hotel.getHotelRooms()) {
                    room.setHotel(hotel); // Set the hotel for each room
                }
            }
            hotelDao.saveAll(hotels);
            System.out.println("Hotels Saved!");
        } catch (Exception e) {
            System.out.println("Unable to save hotels: " + e.getMessage());
        }
    }
    
}
