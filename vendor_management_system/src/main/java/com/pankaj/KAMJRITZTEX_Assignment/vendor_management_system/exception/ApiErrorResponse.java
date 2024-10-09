package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.exception;

import lombok.Data;

@Data
public class ApiErrorResponse {
    private final String errorCode;
    private final String message;
    private final Integer statusCode;
    private final String statusName;
}