package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.jwtService.impl;


import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.dto.JwtAuthenticationResponse;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.dto.SignInRequest;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.User;

public interface AuthenticationService {

    User signUp(User signUpRequest);

    JwtAuthenticationResponse signIn(SignInRequest signInRequest);


}
