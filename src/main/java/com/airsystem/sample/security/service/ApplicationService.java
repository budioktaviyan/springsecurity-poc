package com.airsystem.sample.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.airsystem.sample.security.domain.Account;
import com.airsystem.sample.security.repository.IAccountRepository;
import com.airsystem.sample.security.utils.Configs;
import com.airsystem.sample.security.utils.Constants;

/**
 * @author Budi Oktaviyan Suryanto (budi.oktaviyan@icloud.com)
 */
@Service
public class ApplicationService implements UserDetailsService {
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationService.class.getSimpleName());

	@Autowired
	IAccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username);
		LOG.info(String.format("ApplicationService.loadUserByUsername(%s)", username));

		if (account == null) {
			StringBuilder exceptionBuilder = new StringBuilder("Could not find the user '");
			exceptionBuilder.append(username).append("'");

			throw new UsernameNotFoundException(exceptionBuilder.toString());
		}

		return new User(account.getUsername(), account.getPassword(),
						Constants.IS_ENABLED, Constants.ACC_NOT_EXPIRED, Constants.CREDENTIAL_NOT_EXPIRED, Constants.ACC_NOT_LOCKED,
						AuthorityUtils.createAuthorityList(Configs.ROLE_ADMIN));
	}
}