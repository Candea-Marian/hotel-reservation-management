package com.candea.hotelmanagement.entity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails {

    private User user;

    public SecurityUser(User user) {
        this.user = user;
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
        public String getPassword() {
            return user.getPassword();
        }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(user
                                .getRole()
                                .split(","))
                                .map(SimpleGrantedAuthority::new)
                                .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
