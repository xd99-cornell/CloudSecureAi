package com.cloudsecure.backend.service;

import com.cloudsecure.backend.dto.CloudAccountDto;
import com.cloudsecure.backend.entity.CloudAccount;
import com.cloudsecure.backend.repository.CloudAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CloudAccountService {

    @Autowired
    private CloudAccountRepository cloudAccountRepository;

    public List<CloudAccountDto> getAllCloudAccounts() {
        return cloudAccountRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CloudAccountDto getCloudAccountById(Long id) {
        Optional<CloudAccount> account = cloudAccountRepository.findById(id);
        return account.map(this::convertToDto).orElse(null);
    }

    public CloudAccountDto createCloudAccount(CloudAccountDto accountDto) {
        CloudAccount account = new CloudAccount();
        account.setAccountName(accountDto.getAccountName());
        account.setProvider(accountDto.getProvider());
        account.setAccountId(accountDto.getAccountId());
        account.setRegion(accountDto.getRegion());
        account.setStatus(accountDto.getStatus());
        account.setHealthStatus(accountDto.getHealthStatus());
        account.setDescription(accountDto.getDescription());
        account.setAccessKey(accountDto.getAccessKey());
        account.setSecretKey(accountDto.getSecretKey());
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());
        account.setNotificationCount(0);

        CloudAccount savedAccount = cloudAccountRepository.save(account);
        return convertToDto(savedAccount);
    }

    public CloudAccountDto updateCloudAccount(Long id, CloudAccountDto accountDto) {
        Optional<CloudAccount> accountOpt = cloudAccountRepository.findById(id);
        if (accountOpt.isPresent()) {
            CloudAccount account = accountOpt.get();
            account.setAccountName(accountDto.getAccountName());
            account.setProvider(accountDto.getProvider());
            account.setAccountId(accountDto.getAccountId());
            account.setRegion(accountDto.getRegion());
            account.setStatus(accountDto.getStatus());
            account.setHealthStatus(accountDto.getHealthStatus());
            account.setDescription(accountDto.getDescription());
            account.setAccessKey(accountDto.getAccessKey());
            account.setSecretKey(accountDto.getSecretKey());
            account.setUpdatedAt(LocalDateTime.now());

            CloudAccount savedAccount = cloudAccountRepository.save(account);
            return convertToDto(savedAccount);
        }
        return null;
    }

    public boolean deleteCloudAccount(Long id) {
        if (cloudAccountRepository.existsById(id)) {
            cloudAccountRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public CloudAccountDto updateAccountStatus(Long id, String status) {
        Optional<CloudAccount> accountOpt = cloudAccountRepository.findById(id);
        if (accountOpt.isPresent()) {
            CloudAccount account = accountOpt.get();
            account.setStatus(status);
            account.setUpdatedAt(LocalDateTime.now());
            CloudAccount savedAccount = cloudAccountRepository.save(account);
            return convertToDto(savedAccount);
        }
        return null;
    }

    public CloudAccountDto updateAccountHealth(Long id, String healthStatus) {
        Optional<CloudAccount> accountOpt = cloudAccountRepository.findById(id);
        if (accountOpt.isPresent()) {
            CloudAccount account = accountOpt.get();
            account.setHealthStatus(healthStatus);
            account.setUpdatedAt(LocalDateTime.now());
            CloudAccount savedAccount = cloudAccountRepository.save(account);
            return convertToDto(savedAccount);
        }
        return null;
    }

    public CloudAccountDto syncAccount(Long id) {
        Optional<CloudAccount> accountOpt = cloudAccountRepository.findById(id);
        if (accountOpt.isPresent()) {
            CloudAccount account = accountOpt.get();
            account.setLastSync(LocalDateTime.now());
            account.setStatus("CONNECTED");
            account.setUpdatedAt(LocalDateTime.now());
            CloudAccount savedAccount = cloudAccountRepository.save(account);
            return convertToDto(savedAccount);
        }
        return null;
    }

    private CloudAccountDto convertToDto(CloudAccount account) {
        return new CloudAccountDto(
                account.getId(),
                account.getAccountName(),
                account.getProvider(),
                account.getAccountId(),
                account.getRegion(),
                account.getStatus(),
                account.getHealthStatus(),
                account.getDescription(),
                account.getLastSync(),
                account.getCreatedAt(),
                account.getUpdatedAt(),
                account.getNotificationCount(),
                account.getLastError(),
                account.getAccessKey(),
                account.getSecretKey()
        );
    }
}
