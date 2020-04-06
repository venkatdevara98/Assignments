package com.venkat.phonebook.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.phonebook.entity.Contact;
import com.venkat.phonebook.service.ContactService;

@RestController
@RequestMapping("/api")
public class ContactRestController {
  
	@Autowired
	private ContactService contactService;
	
	
	@GetMapping("/contacts")
	public List<Contact> listAll(){
		return contactService.listAll();
	}
	
	@GetMapping("/contacts/{contactId}")
	public Contact listById(@PathVariable int contactId) {
		Contact contact=contactService.listById(contactId);
		return contact;
	}
	
	@PostMapping("/contacts")
	public Contact addContact(@RequestBody Contact theContact) {
		theContact.setId(0);
		return contactService.save(theContact);
		
	}
	
	@PutMapping("/contacts")
	public Contact updateContact(@RequestBody Contact theContact) {
		contactService.save(theContact);
		return theContact;
	}
	
	@DeleteMapping("/contacts/{contactId}")
	public String deleteContact(@PathVariable int contactId) {
	    contactService.deleteById(contactId);
	    return "Contact with id : "+contactId+" deleted";
	}
}
