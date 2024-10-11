package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.controller;

import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Contract;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Interaction;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.PerformanceMetric;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Vendor;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping("/onboard")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<Vendor> onboardVendor(@RequestBody Vendor vendor) {
        return ResponseEntity.ok(vendorService.onboardVendor(vendor));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ADMIN','USER')")
    public ResponseEntity<Vendor> getVendorById(@PathVariable String id) {
        return vendorService.getVendorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ADMIN','USER')")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<Vendor> updateVendor(@PathVariable String id, @RequestBody Vendor vendor) {
        vendor.setId(id);
        return ResponseEntity.ok(vendorService.updateVendor(vendor));
    }

    @PostMapping("/{vendorId}/contracts")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<Vendor> addContractToVendor(@PathVariable String vendorId, @RequestBody Contract contract) {
        return ResponseEntity.ok(vendorService.addContractToVendor(vendorId, contract));
    }

    @PutMapping("/{vendorId}/contracts")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<Vendor> updateContractForVendor(@PathVariable String vendorId, @RequestBody Contract contract) {
        return ResponseEntity.ok(vendorService.updateContractForVendor(vendorId, contract));
    }

    @PostMapping("/{vendorId}/performance")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<Vendor> addPerformanceMetricToVendor(@PathVariable String vendorId, @RequestBody PerformanceMetric metric) {
        return ResponseEntity.ok(vendorService.addPerformanceMetricToVendor(vendorId, metric));
    }

    @PutMapping("/{vendorId}/performance")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<Vendor> updatePerformanceMetricForVendor(@PathVariable String vendorId, @RequestBody PerformanceMetric metric) {
        return ResponseEntity.ok(vendorService.updatePerformanceMetricForVendor(vendorId, metric));
    }

    @PostMapping("/{vendorId}/interactions")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<Vendor> logInteractionForVendor(@PathVariable String vendorId, @RequestBody Interaction interaction) {
        return ResponseEntity.ok(vendorService.logInteractionForVendor(vendorId, interaction));
    }

    @PutMapping("/{vendorId}/interactions")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<Vendor> updateInteractionForVendor(@PathVariable String vendorId, @RequestBody Interaction interaction) {
        return ResponseEntity.ok(vendorService.updateInteractionForVendor(vendorId, interaction));
    }

}
