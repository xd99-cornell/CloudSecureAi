package com.cloudsecure.backend.controller;

import com.cloudsecure.backend.dto.CloudResourceDto;
import com.cloudsecure.backend.dto.InventoryDashboardDto;
import com.cloudsecure.backend.service.CloudResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cloud-resources")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CloudResourceController {

    @Autowired
    private CloudResourceService cloudResourceService;

    @GetMapping
    public ResponseEntity<List<CloudResourceDto>> getAllResources() {
        List<CloudResourceDto> resources = cloudResourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<InventoryDashboardDto> getInventoryDashboard() {
        InventoryDashboardDto dashboard = cloudResourceService.getInventoryDashboard();
        return ResponseEntity.ok(dashboard);
    }

    @GetMapping("/provider/{provider}")
    public ResponseEntity<List<CloudResourceDto>> getResourcesByProvider(@PathVariable String provider) {
        List<CloudResourceDto> resources = cloudResourceService.getResourcesByProvider(provider);
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/region/{region}")
    public ResponseEntity<List<CloudResourceDto>> getResourcesByRegion(@PathVariable String region) {
        List<CloudResourceDto> resources = cloudResourceService.getResourcesByRegion(region);
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<CloudResourceDto>> getResourcesByType(@PathVariable String type) {
        List<CloudResourceDto> resources = cloudResourceService.getResourcesByType(type);
        return ResponseEntity.ok(resources);
    }

    @PostMapping
    public ResponseEntity<CloudResourceDto> createResource(@RequestBody CloudResourceDto resourceDto) {
        CloudResourceDto createdResource = cloudResourceService.createResource(resourceDto);
        return ResponseEntity.ok(createdResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CloudResourceDto> updateResource(@PathVariable Long id, @RequestBody CloudResourceDto resourceDto) {
        CloudResourceDto updatedResource = cloudResourceService.updateResource(id, resourceDto);
        if (updatedResource != null) {
            return ResponseEntity.ok(updatedResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        boolean deleted = cloudResourceService.deleteResource(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
