package com.airsystem.sample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.airsystem.sample.security.service.ApplicationService;

/**
 * @author Budi Oktaviyan Suryanto (budi.oktaviyan@icloud.com)
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ApplicationAuthentication extends GlobalAuthenticationConfigurerAdapter {
	@Autowired
	private ApplicationService applicationService;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(applicationService);
		authProvider.setPasswordEncoder(shaPasswordEncoder);
		auth.authenticationProvider(authProvider);
	}
}