package com.cloudsecure.backend.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class InventoryDashboardDto {
    private Long totalResources;
    private BigDecimal totalMonthlyCost;
    private Long runningResources;
    private Long stoppedResources;
    private Long terminatedResources;
    
    // Provider breakdown
    private Map<String, Long> resourcesByProvider;
    private Map<String, BigDecimal> costsByProvider;
    
    // Regional distribution
    private Map<String, Long> resourcesByRegion;
    private Map<String, BigDecimal> costsByRegion;
    
    // Resource type breakdown
    private Map<String, Long> resourcesByType;
    private Map<String, BigDecimal> costsByType;
    
    // Recent resources
    private List<CloudResourceDto> recentResources;
    
    // Cost trends (last 6 months)
    private Map<String, BigDecimal> monthlyCostTrend;
    
    // Top expensive resources
    private List<CloudResourceDto> topExpensiveResources;

    // Constructors
    public InventoryDashboardDto() {}

    // Getters and Setters
    public Long getTotalResources() {
        return totalResources;
    }

    public void setTotalResources(Long totalResources) {
        this.totalResources = totalResources;
    }

    public BigDecimal getTotalMonthlyCost() {
        return totalMonthlyCost;
    }

    public void setTotalMonthlyCost(BigDecimal totalMonthlyCost) {
        this.totalMonthlyCost = totalMonthlyCost;
    }

    public Long getRunningResources() {
        return runningResources;
    }

    public void setRunningResources(Long runningResources) {
        this.runningResources = runningResources;
    }

    public Long getStoppedResources() {
        return stoppedResources;
    }

    public void setStoppedResources(Long stoppedResources) {
        this.stoppedResources = stoppedResources;
    }

    public Long getTerminatedResources() {
        return terminatedResources;
    }

    public void setTerminatedResources(Long terminatedResources) {
        this.terminatedResources = terminatedResources;
    }

    public Map<String, Long> getResourcesByProvider() {
        return resourcesByProvider;
    }

    public void setResourcesByProvider(Map<String, Long> resourcesByProvider) {
        this.resourcesByProvider = resourcesByProvider;
    }

    public Map<String, BigDecimal> getCostsByProvider() {
        return costsByProvider;
    }

    public void setCostsByProvider(Map<String, BigDecimal> costsByProvider) {
        this.costsByProvider = costsByProvider;
    }

    public Map<String, Long> getResourcesByRegion() {
        return resourcesByRegion;
    }

    public void setResourcesByRegion(Map<String, Long> resourcesByRegion) {
        this.resourcesByRegion = resourcesByRegion;
    }

    public Map<String, BigDecimal> getCostsByRegion() {
        return costsByRegion;
    }

    public void setCostsByRegion(Map<String, BigDecimal> costsByRegion) {
        this.costsByRegion = costsByRegion;
    }

    public Map<String, Long> getResourcesByType() {
        return resourcesByType;
    }

    public void setResourcesByType(Map<String, Long> resourcesByType) {
        this.resourcesByType = resourcesByType;
    }

    public Map<String, BigDecimal> getCostsByType() {
        return costsByType;
    }

    public void setCostsByType(Map<String, BigDecimal> costsByType) {
        this.costsByType = costsByType;
    }

    public List<CloudResourceDto> getRecentResources() {
        return recentResources;
    }

    public void setRecentResources(List<CloudResourceDto> recentResources) {
        this.recentResources = recentResources;
    }

    public Map<String, BigDecimal> getMonthlyCostTrend() {
        return monthlyCostTrend;
    }

    public void setMonthlyCostTrend(Map<String, BigDecimal> monthlyCostTrend) {
        this.monthlyCostTrend = monthlyCostTrend;
    }

    public List<CloudResourceDto> getTopExpensiveResources() {
        return topExpensiveResources;
    }

    public void setTopExpensiveResources(List<CloudResourceDto> topExpensiveResources) {
        this.topExpensiveResources = topExpensiveResources;
    }
}
