package com.airsystem.sample.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airsystem.sample.security.domain.Account;
import com.airsystem.sample.security.repository.IAccountRepository;

/**
 * @author Budi Oktaviyan Suryanto (budi.oktaviyan@icloud.com)
 */
@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
	@Autowired
	private IAccountRepository accountRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Account getById(@PathVariable Long id) {
		return accountRepository.findOne(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Account create(@RequestBody Account account) {
		ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
		account.setPassword(shaPasswordEncoder.encodePassword(account.getPassword(), null));

		return accountRepository.saveAndFlush(account);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Account update(@PathVariable Long id, @RequestBody Account accounts) {
		ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
		Account account = accountRepository.findOne(id);
		account.setUsername(accounts.getUsername());
		account.setPassword(shaPasswordEncoder.encodePassword(accounts.getPassword(), null));

		return accountRepository.saveAndFlush(account);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		accountRepository.delete(id);
	}

	@RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
	public void deleteAll() {
		accountRepository.deleteAll();
	}
}