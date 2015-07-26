package com.airsystem.sample.security.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Budi Oktaviyan Suryanto (budi.oktaviyan@icloud.com)
 */
@Entity
public class Contact implements Serializable {
	private static final long serialVersionUID = -1521168348558133477L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstname;
	private String lastname;
	private String address;
	private String phonenumber;
	private String email;
	private String twitter;
	private String facebook;
	private String linkedin;
	private String googleplus;

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		id = pId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String pFirstname) {
		firstname = pFirstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String pLastname) {
		lastname = pLastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String pAddress) {
		address = pAddress;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String pPhonenumber) {
		phonenumber = pPhonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String pEmail) {
		email = pEmail;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String pTwitter) {
		twitter = pTwitter;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String pFacebook) {
		facebook = pFacebook;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String pLinkedin) {
		linkedin = pLinkedin;
	}

	public String getGoogleplus() {
		return googleplus;
	}

	public void setGoogleplus(String pGoogleplus) {
		googleplus = pGoogleplus;
	}
}