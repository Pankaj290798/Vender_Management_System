package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.controller;

import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.User;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuperAdminController {

    @Autowired
    private SuperAdminService service;

    @PostMapping("/saveAdmin")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok().body(service.saveAdmin(user));
    }

    @GetMapping("/getAllAdmin")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<List<User>> getAllAdmin(){
        return ResponseEntity.ok().body(service.getAllAdmin());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<String> deleteAdmin(@PathVariable String id){
        return ResponseEntity.ok().body(service.deleteAdmin(id));
    }

}
