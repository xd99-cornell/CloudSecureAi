package com.cloudsecure.backend.repository;

import com.cloudsecure.backend.entity.CloudResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CloudResourceRepository extends JpaRepository<CloudResource, Long> {
    List<CloudResource> findByProvider(String provider);
    List<CloudResource> findByRegion(String region);
    List<CloudResource> findByResourceType(String resourceType);
    List<CloudResource> findByStatus(String status);
    List<CloudResource> findByAccountId(String accountId);
    
    @Query("SELECT COUNT(r) FROM CloudResource r WHERE r.provider = :provider")
    Long countByProvider(@Param("provider") String provider);
    
    @Query("SELECT COUNT(r) FROM CloudResource r WHERE r.region = :region")
    Long countByRegion(@Param("region") String region);
    
    @Query("SELECT COUNT(r) FROM CloudResource r WHERE r.status = :status")
    Long countByStatus(@Param("status") String status);
    
    @Query("SELECT SUM(r.monthlyCost) FROM CloudResource r WHERE r.provider = :provider")
    BigDecimal getTotalCostByProvider(@Param("provider") String provider);
    
    @Query("SELECT SUM(r.monthlyCost) FROM CloudResource r")
    BigDecimal getTotalCost();
    
    @Query("SELECT r.provider, COUNT(r) FROM CloudResource r GROUP BY r.provider")
    List<Object[]> getResourceCountByProvider();
    
    @Query("SELECT r.region, COUNT(r) FROM CloudResource r GROUP BY r.region")
    List<Object[]> getResourceCountByRegion();
    
    @Query("SELECT r.resourceType, COUNT(r) FROM CloudResource r GROUP BY r.resourceType")
    List<Object[]> getResourceCountByType();
}
