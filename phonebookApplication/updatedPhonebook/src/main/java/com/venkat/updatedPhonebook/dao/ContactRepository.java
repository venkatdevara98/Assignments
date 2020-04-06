package com.venkat.updatedPhonebook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkat.updatedPhonebook.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	
	
}
