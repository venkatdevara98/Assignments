package com.venkat.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venkat.phonebook.dao.ContactDAO;
import com.venkat.phonebook.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	@Transactional
	public List<Contact> listAll() {
		return contactDAO.listAll();
	}
	

	@Override
	@Transactional
	public Contact listById(int thisId) {
		
		return contactDAO.listById(thisId);
	}

	@Override
	@Transactional
	public Contact save(Contact thisContact) {
		
		contactDAO.save(thisContact);
        return contactDAO.listById(thisContact.getId());
	}

	@Override
	@Transactional
	public void deleteById(int thisId) {
		
		contactDAO.deleteById(thisId);

	}
    
	
	
}
