package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.jwtService.impl;

import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.dto.JwtAuthenticationResponse;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.dto.SignInRequest;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.dto.SignUpRequest;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.exception.ApplicationException;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.User;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Role;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public User signUp(SignUpRequest signUpRequest){
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
        if (!signUpRequest.getPassword().matches(passwordPattern)) {
            throw new ApplicationException("Password must have at least one uppercase letter, one lowercase letter, one special character, and one digit.",
                    "",
                    HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signIn(SignInRequest signInRequest){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),signInRequest.getPassword()));
        var user =userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(()-> new IllegalArgumentException("Email not found"));
        var jwt =jwtService.generateToken(user);
        var refreshToken =jwtService.generateRefreshToken(new HashMap<>(), user);
        JwtAuthenticationResponse jwtAuthenticationResponse =new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }

}
