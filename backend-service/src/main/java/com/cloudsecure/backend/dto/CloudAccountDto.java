package com.cloudsecure.backend.dto;

import java.time.LocalDateTime;

public class CloudAccountDto {
    private Long id;
    private String accountName;
    private String provider;
    private String accountId;
    private String region;
    private String status;
    private String healthStatus;
    private String description;
    private LocalDateTime lastSync;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer notificationCount;
    private String lastError;
    private String accessKey;
    private String secretKey;

    // Constructors
    public CloudAccountDto() {}

    public CloudAccountDto(Long id, String accountName, String provider, String accountId, 
                          String region, String status, String healthStatus, String description,
                          LocalDateTime lastSync, LocalDateTime createdAt, LocalDateTime updatedAt,
                          Integer notificationCount, String lastError, String accessKey, String secretKey) {
        this.id = id;
        this.accountName = accountName;
        this.provider = provider;
        this.accountId = accountId;
        this.region = region;
        this.status = status;
        this.healthStatus = healthStatus;
        this.description = description;
        this.lastSync = lastSync;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.notificationCount = notificationCount;
        this.lastError = lastError;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLastSync() {
        return lastSync;
    }

    public void setLastSync(LocalDateTime lastSync) {
        this.lastSync = lastSync;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getNotificationCount() {
        return notificationCount;
    }

    public void setNotificationCount(Integer notificationCount) {
        this.notificationCount = notificationCount;
    }

    public String getLastError() {
        return lastError;
    }

    public void setLastError(String lastError) {
        this.lastError = lastError;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
