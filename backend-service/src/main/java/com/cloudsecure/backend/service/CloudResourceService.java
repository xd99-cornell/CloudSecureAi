package com.cloudsecure.backend.service;

import com.cloudsecure.backend.dto.CloudResourceDto;
import com.cloudsecure.backend.dto.InventoryDashboardDto;
import com.cloudsecure.backend.entity.CloudResource;
import com.cloudsecure.backend.repository.CloudResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CloudResourceService {

    @Autowired
    private CloudResourceRepository cloudResourceRepository;

    public List<CloudResourceDto> getAllResources() {
        return cloudResourceRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CloudResourceDto> getResourcesByProvider(String provider) {
        return cloudResourceRepository.findByProvider(provider).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CloudResourceDto> getResourcesByRegion(String region) {
        return cloudResourceRepository.findByRegion(region).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CloudResourceDto> getResourcesByType(String resourceType) {
        return cloudResourceRepository.findByResourceType(resourceType).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public InventoryDashboardDto getInventoryDashboard() {
        InventoryDashboardDto dashboard = new InventoryDashboardDto();
        
        // Total resources
        Long totalResources = cloudResourceRepository.count();
        dashboard.setTotalResources(totalResources);
        
        // Total monthly cost
        BigDecimal totalCost = cloudResourceRepository.getTotalCost();
        dashboard.setTotalMonthlyCost(totalCost != null ? totalCost : BigDecimal.ZERO);
        
        // Status breakdown
        dashboard.setRunningResources(cloudResourceRepository.countByStatus("Running"));
        dashboard.setStoppedResources(cloudResourceRepository.countByStatus("Stopped"));
        dashboard.setTerminatedResources(cloudResourceRepository.countByStatus("Terminated"));
        
        // Provider breakdown
        List<Object[]> providerCounts = cloudResourceRepository.getResourceCountByProvider();
        Map<String, Long> resourcesByProvider = new HashMap<>();
        Map<String, BigDecimal> costsByProvider = new HashMap<>();
        
        for (Object[] result : providerCounts) {
            String provider = (String) result[0];
            Long count = (Long) result[1];
            resourcesByProvider.put(provider, count);
            
            BigDecimal cost = cloudResourceRepository.getTotalCostByProvider(provider);
            costsByProvider.put(provider, cost != null ? cost : BigDecimal.ZERO);
        }
        dashboard.setResourcesByProvider(resourcesByProvider);
        dashboard.setCostsByProvider(costsByProvider);
        
        // Regional breakdown
        List<Object[]> regionCounts = cloudResourceRepository.getResourceCountByRegion();
        Map<String, Long> resourcesByRegion = new HashMap<>();
        for (Object[] result : regionCounts) {
            String region = (String) result[0];
            Long count = (Long) result[1];
            resourcesByRegion.put(region, count);
        }
        dashboard.setResourcesByRegion(resourcesByRegion);
        
        // Resource type breakdown
        List<Object[]> typeCounts = cloudResourceRepository.getResourceCountByType();
        Map<String, Long> resourcesByType = new HashMap<>();
        for (Object[] result : typeCounts) {
            String type = (String) result[0];
            Long count = (Long) result[1];
            resourcesByType.put(type, count);
        }
        dashboard.setResourcesByType(resourcesByType);
        
        // Recent resources (last 10)
        List<CloudResource> recentResources = cloudResourceRepository.findAll().stream()
                .sorted((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()))
                .limit(10)
                .collect(Collectors.toList());
        dashboard.setRecentResources(recentResources.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList()));
        
        // Top expensive resources
        List<CloudResource> expensiveResources = cloudResourceRepository.findAll().stream()
                .filter(r -> r.getMonthlyCost() != null)
                .sorted((a, b) -> b.getMonthlyCost().compareTo(a.getMonthlyCost()))
                .limit(10)
                .collect(Collectors.toList());
        dashboard.setTopExpensiveResources(expensiveResources.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList()));
        
        return dashboard;
    }

    public CloudResourceDto createResource(CloudResourceDto resourceDto) {
        CloudResource resource = new CloudResource();
        resource.setResourceId(resourceDto.getResourceId());
        resource.setResourceName(resourceDto.getResourceName());
        resource.setResourceType(resourceDto.getResourceType());
        resource.setProvider(resourceDto.getProvider());
        resource.setRegion(resourceDto.getRegion());
        resource.setStatus(resourceDto.getStatus());
        resource.setInstanceType(resourceDto.getInstanceType());
        resource.setOperatingSystem(resourceDto.getOperatingSystem());
        resource.setMonthlyCost(resourceDto.getMonthlyCost());
        resource.setTags(resourceDto.getTags());
        resource.setAccountId(resourceDto.getAccountId());
        resource.setDescription(resourceDto.getDescription());
        resource.setCreatedAt(LocalDateTime.now());
        resource.setLastModified(LocalDateTime.now());

        CloudResource savedResource = cloudResourceRepository.save(resource);
        return convertToDto(savedResource);
    }

    public CloudResourceDto updateResource(Long id, CloudResourceDto resourceDto) {
        Optional<CloudResource> resourceOpt = cloudResourceRepository.findById(id);
        if (resourceOpt.isPresent()) {
            CloudResource resource = resourceOpt.get();
            resource.setResourceName(resourceDto.getResourceName());
            resource.setResourceType(resourceDto.getResourceType());
            resource.setProvider(resourceDto.getProvider());
            resource.setRegion(resourceDto.getRegion());
            resource.setStatus(resourceDto.getStatus());
            resource.setInstanceType(resourceDto.getInstanceType());
            resource.setOperatingSystem(resourceDto.getOperatingSystem());
            resource.setMonthlyCost(resourceDto.getMonthlyCost());
            resource.setTags(resourceDto.getTags());
            resource.setDescription(resourceDto.getDescription());
            resource.setLastModified(LocalDateTime.now());

            CloudResource savedResource = cloudResourceRepository.save(resource);
            return convertToDto(savedResource);
        }
        return null;
    }

    public boolean deleteResource(Long id) {
        if (cloudResourceRepository.existsById(id)) {
            cloudResourceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private CloudResourceDto convertToDto(CloudResource resource) {
        return new CloudResourceDto(
                resource.getId(),
                resource.getResourceId(),
                resource.getResourceName(),
                resource.getResourceType(),
                resource.getProvider(),
                resource.getRegion(),
                resource.getStatus(),
                resource.getInstanceType(),
                resource.getOperatingSystem(),
                resource.getMonthlyCost(),
                resource.getTags(),
                resource.getCreatedAt(),
                resource.getLastModified(),
                resource.getAccountId(),
                resource.getDescription()
        );
    }
}
