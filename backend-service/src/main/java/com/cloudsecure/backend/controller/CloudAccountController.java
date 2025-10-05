package com.cloudsecure.backend.controller;

import com.cloudsecure.backend.dto.CloudAccountDto;
import com.cloudsecure.backend.service.CloudAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cloud-accounts")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CloudAccountController {

    @Autowired
    private CloudAccountService cloudAccountService;

    @GetMapping
    public ResponseEntity<List<CloudAccountDto>> getAllCloudAccounts() {
        List<CloudAccountDto> accounts = cloudAccountService.getAllCloudAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CloudAccountDto> getCloudAccountById(@PathVariable Long id) {
        CloudAccountDto account = cloudAccountService.getCloudAccountById(id);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CloudAccountDto> createCloudAccount(@RequestBody CloudAccountDto accountDto) {
        CloudAccountDto createdAccount = cloudAccountService.createCloudAccount(accountDto);
        return ResponseEntity.ok(createdAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CloudAccountDto> updateCloudAccount(@PathVariable Long id, @RequestBody CloudAccountDto accountDto) {
        CloudAccountDto updatedAccount = cloudAccountService.updateCloudAccount(id, accountDto);
        if (updatedAccount != null) {
            return ResponseEntity.ok(updatedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCloudAccount(@PathVariable Long id) {
        boolean deleted = cloudAccountService.deleteCloudAccount(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<CloudAccountDto> updateAccountStatus(@PathVariable Long id, @RequestParam String status) {
        CloudAccountDto updatedAccount = cloudAccountService.updateAccountStatus(id, status);
        if (updatedAccount != null) {
            return ResponseEntity.ok(updatedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/health")
    public ResponseEntity<CloudAccountDto> updateAccountHealth(@PathVariable Long id, @RequestParam String healthStatus) {
        CloudAccountDto updatedAccount = cloudAccountService.updateAccountHealth(id, healthStatus);
        if (updatedAccount != null) {
            return ResponseEntity.ok(updatedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/sync")
    public ResponseEntity<CloudAccountDto> syncAccount(@PathVariable Long id) {
        CloudAccountDto syncedAccount = cloudAccountService.syncAccount(id);
        if (syncedAccount != null) {
            return ResponseEntity.ok(syncedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
