package com.venkat.updatedPhonebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkat.updatedPhonebook.dao.ContactRepository;
import com.venkat.updatedPhonebook.dto.ContactDTO;
import com.venkat.updatedPhonebook.entity.Contact;



@Service
public class ContactServiceImpl implements ContactService {

	
	private ContactRepository contactRepository;
	
	
	@Autowired
	public ContactServiceImpl(ContactRepository theContactRepository) {
		contactRepository = theContactRepository;
	}
	
	@Override
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	
	@Override
	public Contact findById(int theId) {
		Optional<Contact> result = contactRepository.findById(theId);
		
		Contact theContact = null;
		
		if (result.isPresent()) {
			theContact = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theContact;
	}

	@Override
	public void save(Contact theContact) {
	  contactRepository.save(theContact);
	}

	@Override
	public void deleteById(int theId) {
		contactRepository.deleteById(theId);
	}

	
	

	

}






