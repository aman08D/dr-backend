package com.dr.backend.security;

import com.dr.backend.model.User;
import com.dr.backend.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Hamara Database Layer
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Hum Spring Security ko keh rahe hain:
        // "Bhai tum tension mat lo, mere UserRepository se Email dhund ke lata hu!"
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        return new CustomUserDetails(user);
    }
}
