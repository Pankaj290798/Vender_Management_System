package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.jwtService.impl;

import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsservice() {
        return  new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username).orElseThrow(() ->new UsernameNotFoundException("User not found"));
            }
        };
    }
}
