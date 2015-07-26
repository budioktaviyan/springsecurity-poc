package com.airsystem.sample.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airsystem.sample.security.domain.Account;

/**
 * @author Budi Oktaviyan Suryanto (budi.oktaviyan@icloud.com)
 */
@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
	Account findByUsername(String username);
}