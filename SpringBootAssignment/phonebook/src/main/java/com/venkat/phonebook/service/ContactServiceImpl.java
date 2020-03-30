package com.venkat.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkat.phonebook.dao.ContactDAO;
import com.venkat.phonebook.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public List<Contact> listAll() {
		return contactDAO.listAll();
	}
	

	@Override
	public Contact listById(int thisId) {
		
		return contactDAO.listById(thisId);
	}

	@Override
	public void save(Contact thisContact) {
		
		contactDAO.save(thisContact);

	}

	@Override
	public void deleteById(int thisId) {
		
		contactDAO.deleteById(thisId);

	}

}
