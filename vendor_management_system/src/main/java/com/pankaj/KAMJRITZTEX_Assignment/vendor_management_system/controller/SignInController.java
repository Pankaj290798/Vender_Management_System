package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.controller;


import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.dto.JwtAuthenticationResponse;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.dto.SignInRequest;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.jwtService.impl.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signIn")
public class SignInController {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @PostMapping()
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }

}
