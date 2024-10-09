package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.repository;

import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String> {
}