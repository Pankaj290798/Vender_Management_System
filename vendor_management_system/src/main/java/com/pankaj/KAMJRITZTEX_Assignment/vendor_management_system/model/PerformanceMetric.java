package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model;

import lombok.Data;

import java.util.Date;

@Data
public class PerformanceMetric {
    private String metricId;
    private String description;
    private Double score;
    private Date date;
}
