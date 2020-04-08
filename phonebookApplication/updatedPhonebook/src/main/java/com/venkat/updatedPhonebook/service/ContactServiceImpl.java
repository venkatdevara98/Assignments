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
	private ModelMapper modelMapper;
	
	@Autowired
	public ContactServiceImpl(ContactRepository theContactRepository,ModelMapper theModelMapper) {
		contactRepository = theContactRepository;
		modelMapper=theModelMapper;
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

	
	@Override
	public ContactDTO getContact(int theId) {
		Optional<Contact> result=contactRepository.findById(theId);
		Contact contact=null;
		if(result.isPresent())
			contact=result.get();
		else
			throw new RuntimeException("Did not find employee id - " + theId);

        ContactDTO contactDTO = modelMapper.map(contact, ContactDTO.class);

	    return contactDTO;
	}

	@Override
	public List<ContactDTO> findAllDTO() {
		List<ContactDTO> contactsDTO=new ArrayList<>();
		List<Contact> contacts=contactRepository.findAll();
		for(Contact contact:contacts) {
			ContactDTO contactDTO=modelMapper.map(contact,ContactDTO.class);
			contactsDTO.add(contactDTO);
		}
		return contactsDTO;
	}

}






