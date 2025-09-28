package com.cloudsecure.backend.controller;

import com.cloudsecure.backend.entity.User;
import com.cloudsecure.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    
    @Autowired
    private AuthService authService;
    
    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getUserProfile() {
        User currentUser = authService.getCurrentUser();
        if (currentUser != null) {
            // Create a response without password
            UserProfileResponse response = new UserProfileResponse(
                currentUser.getId(),
                currentUser.getUsername(),
                currentUser.getEmail(),
                currentUser.getFirstName(),
                currentUser.getLastName(),
                currentUser.getRole().name(),
                currentUser.getCreatedAt()
            );
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body("User not found");
    }
    
    @GetMapping("/test")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> userAccess() {
        return ResponseEntity.ok("User Content.");
    }
    
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminAccess() {
        return ResponseEntity.ok("Admin Board.");
    }
    
    // Inner class for user profile response
    public static class UserProfileResponse {
        private Long id;
        private String username;
        private String email;
        private String firstName;
        private String lastName;
        private String role;
        private java.time.LocalDateTime createdAt;
        
        public UserProfileResponse(Long id, String username, String email, String firstName, 
                                 String lastName, String role, java.time.LocalDateTime createdAt) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
            this.role = role;
            this.createdAt = createdAt;
        }
        
        // Getters
        public Long getId() { return id; }
        public String getUsername() { return username; }
        public String getEmail() { return email; }
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getRole() { return role; }
        public java.time.LocalDateTime getCreatedAt() { return createdAt; }
    }
}
