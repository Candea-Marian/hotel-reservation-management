package com.candea.hotelmanagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.candea.hotelmanagement.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String username);
}
