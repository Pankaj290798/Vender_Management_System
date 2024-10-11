package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "vendors")
public class Vendor {
    @Id
    private String id;
    private String name;
    private String category;
    private String contactInfo;
    private Set<Contract> contracts = new HashSet<>();
    private Set<PerformanceMetric> performanceMetrics = new HashSet<>();
    private Set<Interaction> interactions = new HashSet<>();
    private Date onboardingDate;
}