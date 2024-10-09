package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String token;
    private String refreshToken;
}
