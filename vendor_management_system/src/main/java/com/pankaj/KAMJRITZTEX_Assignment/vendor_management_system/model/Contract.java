package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model;

import lombok.Data;

import java.util.Date;

@Data
public class Contract {
    private String contractId;
    private Date startDate;
    private Date endDate;
    private String contractDetails;
}
