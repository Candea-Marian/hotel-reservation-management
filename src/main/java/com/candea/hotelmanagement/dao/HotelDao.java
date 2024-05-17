package com.candea.hotelmanagement.dao;

import com.candea.hotelmanagement.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDao extends JpaRepository<Hotel, Integer>{

    
}
