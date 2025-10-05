package com.cloudsecure.backend.service;

import com.cloudsecure.backend.entity.CloudAccount;
import com.cloudsecure.backend.entity.CloudResource;
import com.cloudsecure.backend.repository.CloudAccountRepository;
import com.cloudsecure.backend.repository.CloudResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class DataInitializationService implements CommandLineRunner {

    @Autowired
    private CloudAccountRepository cloudAccountRepository;
    
    @Autowired
    private CloudResourceRepository cloudResourceRepository;

    @Override
    public void run(String... args) throws Exception {
        // Only initialize if no data exists
        if (cloudAccountRepository.count() == 0) {
            initializeCloudAccounts();
        }
        
        if (cloudResourceRepository.count() == 0) {
            initializeCloudResources();
        }
    }

    private void initializeCloudAccounts() {
        // AWS Production Account
        CloudAccount awsProd = new CloudAccount();
        awsProd.setAccountName("AWS Production");
        awsProd.setProvider("AWS");
        awsProd.setAccountId("123456789012");
        awsProd.setRegion("us-west-2");
        awsProd.setStatus("CONNECTED");
        awsProd.setHealthStatus("HEALTHY");
        awsProd.setDescription("Primary production environment for web applications");
        awsProd.setLastSync(LocalDateTime.now().minusMinutes(5));
        awsProd.setCreatedAt(LocalDateTime.now().minusDays(30));
        awsProd.setUpdatedAt(LocalDateTime.now().minusMinutes(5));
        awsProd.setNotificationCount(2);
        awsProd.setLastError(null);
        cloudAccountRepository.save(awsProd);

        // AWS Staging Account
        CloudAccount awsStaging = new CloudAccount();
        awsStaging.setAccountName("AWS Staging");
        awsStaging.setProvider("AWS");
        awsStaging.setAccountId("123456789013");
        awsStaging.setRegion("us-east-1");
        awsStaging.setStatus("CONNECTED");
        awsStaging.setHealthStatus("WARNING");
        awsStaging.setDescription("Staging environment for testing and development");
        awsStaging.setLastSync(LocalDateTime.now().minusHours(2));
        awsStaging.setCreatedAt(LocalDateTime.now().minusDays(15));
        awsStaging.setUpdatedAt(LocalDateTime.now().minusHours(2));
        awsStaging.setNotificationCount(5);
        awsStaging.setLastError("High CPU usage detected");
        cloudAccountRepository.save(awsStaging);

        // Azure Production
        CloudAccount azureProd = new CloudAccount();
        azureProd.setAccountName("Azure Production");
        azureProd.setProvider("Azure");
        azureProd.setAccountId("abc123-def456-ghi789");
        azureProd.setRegion("West US 2");
        azureProd.setStatus("CONNECTED");
        azureProd.setHealthStatus("HEALTHY");
        azureProd.setDescription("Azure production environment for enterprise applications");
        azureProd.setLastSync(LocalDateTime.now().minusMinutes(15));
        azureProd.setCreatedAt(LocalDateTime.now().minusDays(45));
        azureProd.setUpdatedAt(LocalDateTime.now().minusMinutes(15));
        azureProd.setNotificationCount(0);
        azureProd.setLastError(null);
        cloudAccountRepository.save(azureProd);

        // Google Cloud Platform
        CloudAccount gcpProd = new CloudAccount();
        gcpProd.setAccountName("GCP Analytics");
        gcpProd.setProvider("GCP");
        gcpProd.setAccountId("my-gcp-project-12345");
        gcpProd.setRegion("us-central1");
        gcpProd.setStatus("PENDING");
        gcpProd.setHealthStatus("UNKNOWN");
        gcpProd.setDescription("Google Cloud Platform for data analytics and ML workloads");
        gcpProd.setLastSync(null);
        gcpProd.setCreatedAt(LocalDateTime.now().minusDays(7));
        gcpProd.setUpdatedAt(LocalDateTime.now().minusDays(7));
        gcpProd.setNotificationCount(1);
        gcpProd.setLastError("Authentication credentials expired");
        cloudAccountRepository.save(gcpProd);

        // AWS Development
        CloudAccount awsDev = new CloudAccount();
        awsDev.setAccountName("AWS Development");
        awsDev.setProvider("AWS");
        awsDev.setAccountId("987654321098");
        awsDev.setRegion("eu-west-1");
        awsDev.setStatus("DISCONNECTED");
        awsDev.setHealthStatus("CRITICAL");
        awsDev.setDescription("Development environment for experimental features");
        awsDev.setLastSync(LocalDateTime.now().minusDays(3));
        awsDev.setCreatedAt(LocalDateTime.now().minusDays(60));
        awsDev.setUpdatedAt(LocalDateTime.now().minusDays(3));
        awsDev.setNotificationCount(8);
        awsDev.setLastError("Network connectivity issues");
        cloudAccountRepository.save(awsDev);

        // Azure Staging
        CloudAccount azureStaging = new CloudAccount();
        azureStaging.setAccountName("Azure Staging");
        azureStaging.setProvider("Azure");
        azureStaging.setAccountId("xyz789-abc123-def456");
        azureStaging.setRegion("East US");
        azureStaging.setStatus("CONNECTED");
        azureStaging.setHealthStatus("WARNING");
        azureStaging.setDescription("Azure staging environment for pre-production testing");
        azureStaging.setLastSync(LocalDateTime.now().minusHours(1));
        azureStaging.setCreatedAt(LocalDateTime.now().minusDays(20));
        azureStaging.setUpdatedAt(LocalDateTime.now().minusHours(1));
        azureStaging.setNotificationCount(3);
        azureStaging.setLastError("Storage quota approaching limit");
        cloudAccountRepository.save(azureStaging);
    }
    
    private void initializeCloudResources() {
        // AWS Resources
        CloudResource awsEC2_1 = new CloudResource();
        awsEC2_1.setResourceId("i-1234567890abcdef0");
        awsEC2_1.setResourceName("Web Server 1");
        awsEC2_1.setResourceType("EC2");
        awsEC2_1.setProvider("AWS");
        awsEC2_1.setRegion("us-east-1");
        awsEC2_1.setStatus("Running");
        awsEC2_1.setInstanceType("t3.medium");
        awsEC2_1.setOperatingSystem("Amazon Linux 2");
        awsEC2_1.setMonthlyCost(new BigDecimal("45.50"));
        awsEC2_1.setTags("Environment:Production,Team:Web");
        awsEC2_1.setAccountId("123456789012");
        awsEC2_1.setDescription("Primary web server for production");
        awsEC2_1.setCreatedAt(LocalDateTime.now().minusDays(30));
        awsEC2_1.setLastModified(LocalDateTime.now().minusDays(5));
        cloudResourceRepository.save(awsEC2_1);

        CloudResource awsS3_1 = new CloudResource();
        awsS3_1.setResourceId("my-bucket-prod");
        awsS3_1.setResourceName("Production Assets");
        awsS3_1.setResourceType("S3");
        awsS3_1.setProvider("AWS");
        awsS3_1.setRegion("us-east-1");
        awsS3_1.setStatus("Running");
        awsS3_1.setMonthlyCost(new BigDecimal("12.30"));
        awsS3_1.setTags("Environment:Production,Team:Web");
        awsS3_1.setAccountId("123456789012");
        awsS3_1.setDescription("Static assets and backups");
        awsS3_1.setCreatedAt(LocalDateTime.now().minusDays(45));
        awsS3_1.setLastModified(LocalDateTime.now().minusDays(2));
        cloudResourceRepository.save(awsS3_1);

        CloudResource awsRDS_1 = new CloudResource();
        awsRDS_1.setResourceId("prod-db-instance");
        awsRDS_1.setResourceName("Production Database");
        awsRDS_1.setResourceType("RDS");
        awsRDS_1.setProvider("AWS");
        awsRDS_1.setRegion("us-east-1");
        awsRDS_1.setStatus("Running");
        awsRDS_1.setInstanceType("db.t3.medium");
        awsRDS_1.setMonthlyCost(new BigDecimal("89.20"));
        awsRDS_1.setTags("Environment:Production,Team:Database");
        awsRDS_1.setAccountId("123456789012");
        awsRDS_1.setDescription("MySQL database for production");
        awsRDS_1.setCreatedAt(LocalDateTime.now().minusDays(60));
        awsRDS_1.setLastModified(LocalDateTime.now().minusDays(1));
        cloudResourceRepository.save(awsRDS_1);

        // Azure Resources
        CloudResource azureVM_1 = new CloudResource();
        azureVM_1.setResourceId("vm-dev-001");
        azureVM_1.setResourceName("Development Server");
        azureVM_1.setResourceType("Virtual Machine");
        azureVM_1.setProvider("Azure");
        azureVM_1.setRegion("East US");
        azureVM_1.setStatus("Running");
        azureVM_1.setInstanceType("Standard_B2s");
        azureVM_1.setOperatingSystem("Ubuntu 20.04");
        azureVM_1.setMonthlyCost(new BigDecimal("67.80"));
        azureVM_1.setTags("Environment:Development,Team:DevOps");
        azureVM_1.setAccountId("abcdef-1234-5678-90ab");
        azureVM_1.setDescription("Development environment server");
        azureVM_1.setCreatedAt(LocalDateTime.now().minusDays(15));
        azureVM_1.setLastModified(LocalDateTime.now().minusDays(3));
        cloudResourceRepository.save(azureVM_1);

        CloudResource azureStorage_1 = new CloudResource();
        azureStorage_1.setResourceId("devstorage001");
        azureStorage_1.setResourceName("Development Storage");
        azureStorage_1.setResourceType("Storage Account");
        azureStorage_1.setProvider("Azure");
        azureStorage_1.setRegion("East US");
        azureStorage_1.setStatus("Running");
        azureStorage_1.setMonthlyCost(new BigDecimal("8.50"));
        azureStorage_1.setTags("Environment:Development,Team:DevOps");
        azureStorage_1.setAccountId("abcdef-1234-5678-90ab");
        azureStorage_1.setDescription("Development data storage");
        azureStorage_1.setCreatedAt(LocalDateTime.now().minusDays(20));
        azureStorage_1.setLastModified(LocalDateTime.now().minusDays(1));
        cloudResourceRepository.save(azureStorage_1);

        // GCP Resources
        CloudResource gcpCompute_1 = new CloudResource();
        gcpCompute_1.setResourceId("gcp-vm-analytics");
        gcpCompute_1.setResourceName("Analytics Server");
        gcpCompute_1.setResourceType("Compute Engine");
        gcpCompute_1.setProvider("GCP");
        gcpCompute_1.setRegion("us-central1");
        gcpCompute_1.setStatus("Running");
        gcpCompute_1.setInstanceType("e2-standard-2");
        gcpCompute_1.setOperatingSystem("Ubuntu 22.04");
        gcpCompute_1.setMonthlyCost(new BigDecimal("52.40"));
        gcpCompute_1.setTags("Environment:Analytics,Team:Data");
        gcpCompute_1.setAccountId("gcp-sandbox-project-123");
        gcpCompute_1.setDescription("Analytics processing server");
        gcpCompute_1.setCreatedAt(LocalDateTime.now().minusDays(10));
        gcpCompute_1.setLastModified(LocalDateTime.now().minusDays(2));
        cloudResourceRepository.save(gcpCompute_1);

        CloudResource gcpStorage_1 = new CloudResource();
        gcpStorage_1.setResourceId("analytics-data-bucket");
        gcpStorage_1.setResourceName("Analytics Data");
        gcpStorage_1.setResourceType("Cloud Storage");
        gcpStorage_1.setProvider("GCP");
        gcpStorage_1.setRegion("us-central1");
        gcpStorage_1.setStatus("Running");
        gcpStorage_1.setMonthlyCost(new BigDecimal("15.70"));
        gcpStorage_1.setTags("Environment:Analytics,Team:Data");
        gcpStorage_1.setAccountId("gcp-sandbox-project-123");
        gcpStorage_1.setDescription("Analytics data storage bucket");
        gcpStorage_1.setCreatedAt(LocalDateTime.now().minusDays(8));
        gcpStorage_1.setLastModified(LocalDateTime.now().minusDays(1));
        cloudResourceRepository.save(gcpStorage_1);

        // DigitalOcean Resources
        CloudResource doDroplet_1 = new CloudResource();
        doDroplet_1.setResourceId("do-staging-001");
        doDroplet_1.setResourceName("Staging Server");
        doDroplet_1.setResourceType("Droplet");
        doDroplet_1.setProvider("DigitalOcean");
        doDroplet_1.setRegion("NYC1");
        doDroplet_1.setStatus("Running");
        doDroplet_1.setInstanceType("s-2vcpu-4gb");
        doDroplet_1.setOperatingSystem("Ubuntu 22.04");
        doDroplet_1.setMonthlyCost(new BigDecimal("24.00"));
        doDroplet_1.setTags("Environment:Staging,Team:QA");
        doDroplet_1.setAccountId("do-staging-env");
        doDroplet_1.setDescription("Staging environment server");
        doDroplet_1.setCreatedAt(LocalDateTime.now().minusDays(5));
        doDroplet_1.setLastModified(LocalDateTime.now().minusDays(1));
        cloudResourceRepository.save(doDroplet_1);

        // Some stopped/terminated resources for variety
        CloudResource stoppedEC2 = new CloudResource();
        stoppedEC2.setResourceId("i-0987654321fedcba0");
        stoppedEC2.setResourceName("Old Web Server");
        stoppedEC2.setResourceType("EC2");
        stoppedEC2.setProvider("AWS");
        stoppedEC2.setRegion("us-west-2");
        stoppedEC2.setStatus("Stopped");
        stoppedEC2.setInstanceType("t2.micro");
        stoppedEC2.setOperatingSystem("Amazon Linux 2");
        stoppedEC2.setMonthlyCost(new BigDecimal("0.00"));
        stoppedEC2.setTags("Environment:Legacy,Team:Web");
        stoppedEC2.setAccountId("123456789012");
        stoppedEC2.setDescription("Legacy web server - stopped");
        stoppedEC2.setCreatedAt(LocalDateTime.now().minusDays(90));
        stoppedEC2.setLastModified(LocalDateTime.now().minusDays(30));
        cloudResourceRepository.save(stoppedEC2);
    }
}
