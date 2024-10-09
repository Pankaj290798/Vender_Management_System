package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.service;

import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Contract;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Interaction;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.PerformanceMetric;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Vendor;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public Vendor onboardVendor(Vendor vendor) {
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
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendor.getContracts().add(contract);
        return vendorRepository.save(vendor);
    }

    public Vendor updateContractForVendor(String vendorId, Contract contract) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendor.getContracts().removeIf(c -> c.getContractId().equals(contract.getContractId()));
        vendor.getContracts().add(contract);
        return vendorRepository.save(vendor);
    }

    public Vendor addPerformanceMetricToVendor(String vendorId, PerformanceMetric metric) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendor.getPerformanceMetrics().add(metric);
        return vendorRepository.save(vendor);
    }

    public Vendor updatePerformanceMetricForVendor(String vendorId, PerformanceMetric metric) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendor.getPerformanceMetrics().removeIf(m -> m.getMetricId().equals(metric.getMetricId()));
        vendor.getPerformanceMetrics().add(metric);
        return vendorRepository.save(vendor);
    }

    public Vendor logInteractionForVendor(String vendorId, Interaction interaction) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendor.getInteractions().add(interaction);
        return vendorRepository.save(vendor);
    }

    public Vendor updateInteractionForVendor(String vendorId, Interaction interaction) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendor.getInteractions().removeIf(i -> i.getInteractionId().equals(interaction.getInteractionId()));
        vendor.getInteractions().add(interaction);
        return vendorRepository.save(vendor);
    }

}
