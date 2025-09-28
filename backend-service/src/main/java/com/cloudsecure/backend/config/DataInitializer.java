package com.cloudsecure.backend.config;

import com.cloudsecure.backend.entity.User;
import com.cloudsecure.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        // Create default admin user if not exists
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@cloudsecure.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setFirstName("System");
            admin.setLastName("Administrator");
            admin.setRole(User.Role.ADMIN);
            
            userRepository.save(admin);
            System.out.println("Default admin user created:");
            System.out.println("Username: admin");
            System.out.println("Password: admin123");
            System.out.println("Email: admin@cloudsecure.com");
        }
        
        // Create default regular user if not exists
        if (!userRepository.existsByUsername("user")) {
            User user = new User();
            user.setUsername("user");
            user.setEmail("user@cloudsecure.com");
            user.setPassword(passwordEncoder.encode("user123"));
            user.setFirstName("Test");
            user.setLastName("User");
            user.setRole(User.Role.USER);
            
            userRepository.save(user);
            System.out.println("Default user created:");
            System.out.println("Username: user");
            System.out.println("Password: user123");
            System.out.println("Email: user@cloudsecure.com");
        }
    }
}
