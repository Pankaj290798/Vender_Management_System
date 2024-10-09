package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.repository;

import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Role;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.User;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
    User findByRole (Role role);
}
