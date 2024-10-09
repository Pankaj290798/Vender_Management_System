package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "vendors")
public class Vendor {
    @Id
    private String id;
    private String name;
    private String category;
    private String contactInfo;
    private List<Contract> contracts;
    private List<PerformanceMetric> performanceMetrics;
    private List<Interaction> interactions;
    private Date onboardingDate;
}