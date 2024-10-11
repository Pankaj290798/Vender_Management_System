package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.service;

import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.exception.ApplicationException;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Contract;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Interaction;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.PerformanceMetric;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Vendor;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public Vendor onboardVendor(Vendor vendor) {
        vendor.setOnboardingDate(new Date());
        return vendorRepository.save(vendor);
    }

    public Optional<Vendor> getVendorById(String id) {
        return vendorRepository.findById(id);
    }

    public Vendor updateVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor addContractToVendor(String vendorId, Contract contract) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new ApplicationException("","Vendor not found", HttpStatus.NOT_FOUND));
        if(vendor.getContracts().isEmpty()){
            vendor.setContracts(new HashSet<>());
        }
        vendor.getContracts().add(contract);
        return vendorRepository.save(vendor);
    }

    public Vendor updateContractForVendor(String vendorId, Contract contract) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new ApplicationException("","Vendor not found", HttpStatus.NOT_FOUND));
        vendor.getContracts().removeIf(c -> c.getContractId().equals(contract.getContractId()));
        vendor.getContracts().add(contract);
        return vendorRepository.save(vendor);
    }

    public Vendor addPerformanceMetricToVendor(String vendorId, PerformanceMetric metric) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new ApplicationException("","Vendor not found", HttpStatus.NOT_FOUND));
        if(vendor.getPerformanceMetrics().isEmpty()){
            vendor.setPerformanceMetrics(new HashSet<>());
        }
        vendor.getPerformanceMetrics().add(metric);
        return vendorRepository.save(vendor);
    }

    public Vendor updatePerformanceMetricForVendor(String vendorId, PerformanceMetric metric) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new ApplicationException("","Vendor not found", HttpStatus.NOT_FOUND));
        vendor.getPerformanceMetrics().removeIf(m -> m.getMetricId().equals(metric.getMetricId()));
        vendor.getPerformanceMetrics().add(metric);
        return vendorRepository.save(vendor);
    }

    public Vendor logInteractionForVendor(String vendorId, Interaction interaction) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new ApplicationException("","Vendor not found", HttpStatus.NOT_FOUND));
        if(vendor.getInteractions().isEmpty()){
            vendor.setInteractions(new HashSet<>());
        }
        vendor.getInteractions().add(interaction);
        return vendorRepository.save(vendor);
    }

    public Vendor updateInteractionForVendor(String vendorId, Interaction interaction) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new ApplicationException("","Vendor not found", HttpStatus.NOT_FOUND));
        vendor.getInteractions().removeIf(i -> i.getInteractionId().equals(interaction.getInteractionId()));
        vendor.getInteractions().add(interaction);
        return vendorRepository.save(vendor);
    }

}
