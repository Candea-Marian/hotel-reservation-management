package com.candea.hotelmanagement.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.candea.hotelmanagement.dao.UserDao;
import com.candea.hotelmanagement.entity.SecurityUser;

@Service
public class JpaUserDetailsService implements UserDetailsService{

    private final UserDao userDao;

    public JpaUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao
                    .findByUserName(username)
                    .map(SecurityUser::new)
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found" + username));
        
    }
    
}
