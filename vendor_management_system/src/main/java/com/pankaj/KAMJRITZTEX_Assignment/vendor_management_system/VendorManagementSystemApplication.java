package com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system;

import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Role;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.User;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.model.Vendor;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.repository.UserRepository;
import com.pankaj.KAMJRITZTEX_Assignment.vendor_management_system.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class VendorManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(VendorManagementSystemApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(Role.SUPER_ADMIN);
		if (adminAccount == null){
			User user = new  User();
			user.setEmail("global@gmail.com");
			user.setFirstName("super");
			user.setLastName("Admin");
			user.setRole(Role.SUPER_ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("Globaldmin@123"));
			userRepository.save(user);
		}
	}
}
