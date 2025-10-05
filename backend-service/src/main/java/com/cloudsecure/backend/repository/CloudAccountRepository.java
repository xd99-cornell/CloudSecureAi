package com.cloudsecure.backend.repository;

import com.cloudsecure.backend.entity.CloudAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CloudAccountRepository extends JpaRepository<CloudAccount, Long> {
    List<CloudAccount> findByProvider(String provider);
    List<CloudAccount> findByStatus(String status);
    List<CloudAccount> findByHealthStatus(String healthStatus);
    List<CloudAccount> findByAccountNameContainingIgnoreCase(String accountName);
}
