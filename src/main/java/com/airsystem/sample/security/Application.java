package com.airsystem.sample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

import com.airsystem.sample.security.service.ApplicationService;

/**
 * @author Budi Oktaviyan Suryanto (budi.oktaviyan@icloud.com)
 */

@SpringBootApplication
@EnableJpaRepositories
public class Application extends GlobalAuthenticationConfigurerAdapter {

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

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}