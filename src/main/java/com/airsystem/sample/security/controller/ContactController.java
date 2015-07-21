package com.airsystem.sample.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airsystem.sample.security.domain.Contact;
import com.airsystem.sample.security.repository.IContactRepository;

/**
 * @author Budi Oktaviyan Suryanto (budi.oktaviyan@icloud.com)
 */

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {

	@Autowired
	private IContactRepository contactRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Contact> getAll() {
		return contactRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Contact getById(@PathVariable Long id) {
		return contactRepository.findOne(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Contact create(@RequestBody Contact contact) {
		return contactRepository.saveAndFlush(contact);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Contact update(@PathVariable Long id, @RequestBody Contact contacts) {
		Contact contact = contactRepository.findOne(id);
		contact.setFirstname(contacts.getFirstname());
		contact.setLastname(contacts.getLastname());
		contact.setAddress(contacts.getAddress());
		contact.setPhonenumber(contacts.getPhonenumber());
		contact.setEmail(contacts.getEmail());
		contact.setFacebook(contacts.getFacebook());
		contact.setLinkedin(contacts.getLinkedin());
		contact.setGoogleplus(contacts.getGoogleplus());

		return contactRepository.saveAndFlush(contact);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		contactRepository.delete(id);
	}

	@RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
	public void deleteAll() {
		contactRepository.deleteAll();
	}
}