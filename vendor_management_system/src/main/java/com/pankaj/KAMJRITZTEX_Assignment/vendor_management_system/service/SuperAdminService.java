package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.service;

import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.exception.ApplicationException;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Role;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.User;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperAdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveAdmin(User signUpRequest){
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
        if (!signUpRequest.getPassword().matches(passwordPattern)) {
            throw new ApplicationException("Password must have at least one uppercase letter, one lowercase letter, one special character, and one digit.",
                    "",
                    HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
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
