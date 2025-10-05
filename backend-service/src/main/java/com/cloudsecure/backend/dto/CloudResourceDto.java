package com.cloudsecure.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CloudResourceDto {
    private Long id;
    private String resourceId;
    private String resourceName;
    private String resourceType;
    private String provider;
    private String region;
    private String status;
    private String instanceType;
    private String operatingSystem;
    private BigDecimal monthlyCost;
    private String tags;
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;
    private String accountId;
    private String description;

    // Constructors
    public CloudResourceDto() {}

    public CloudResourceDto(Long id, String resourceId, String resourceName, String resourceType,
                           String provider, String region, String status, String instanceType,
                           String operatingSystem, BigDecimal monthlyCost, String tags,
                           LocalDateTime createdAt, LocalDateTime lastModified, String accountId,
                           String description) {
        this.id = id;
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.provider = provider;
        this.region = region;
        this.status = status;
        this.instanceType = instanceType;
        this.operatingSystem = operatingSystem;
        this.monthlyCost = monthlyCost;
        this.tags = tags;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
        this.accountId = accountId;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public BigDecimal getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(BigDecimal monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
