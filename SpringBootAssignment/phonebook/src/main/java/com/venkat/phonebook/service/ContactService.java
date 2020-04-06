package com.venkat.phonebook.service;

import java.util.List;

import com.venkat.phonebook.entity.Contact;

public interface ContactService {
	public List<Contact> listAll();
	public Contact listById(int thisId);
	public Contact save(Contact thisContact);
	public void deleteById(int thisId);
}
