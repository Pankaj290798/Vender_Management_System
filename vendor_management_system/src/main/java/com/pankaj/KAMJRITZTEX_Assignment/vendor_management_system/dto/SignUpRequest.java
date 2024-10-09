package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
