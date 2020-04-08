package com.venkat.updatedPhonebook.service;

import java.util.List;

import com.venkat.updatedPhonebook.dto.ContactDTO;
import com.venkat.updatedPhonebook.entity.Contact;

public interface ContactService {

	public List<Contact> findAll();
	
	public Contact findById(int theId);
	
	public void save(Contact theContact);
	
	public void deleteById(int theId);
	
	public ContactDTO getContact(int theId);
	
	public List<ContactDTO> findAllDTO();
	
}
