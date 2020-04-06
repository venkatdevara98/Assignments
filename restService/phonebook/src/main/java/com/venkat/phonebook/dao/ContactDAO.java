package com.venkat.phonebook.dao;

import java.util.List;

import com.venkat.phonebook.entity.Contact;

public interface ContactDAO {
  
	public List<Contact> listAll();
	public Contact listById(int thisId);
	public void save(Contact thisContact);
	public void deleteById(int thisId);
	
}
