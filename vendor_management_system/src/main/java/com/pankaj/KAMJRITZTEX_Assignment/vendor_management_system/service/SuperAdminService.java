package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.service;

import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Role;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.User;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperAdminService {

    @Autowired
    private UserRepository userRepository;

    public User saveAdmin(User user){
        user.setRole(Role.ADMIN);
        return userRepository.save(user);
    }

    public List<User> getAllAdmin() {
        return userRepository.findAll().stream().filter(e-> e.getRole().equals(Role.ADMIN)).toList();
    }

    public String deleteAdmin(String id) {
        userRepository.deleteById(id);
        return "Admin deleted successfully";
    }
}
