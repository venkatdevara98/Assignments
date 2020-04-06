package com.venkat.phonebook.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.venkat.phonebook.entity.Contact;
import com.venkat.phonebook.service.ContactService;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceTest {

	@Autowired
	private ContactService contactService;
	
	@Test
	public void testlistAll() {
		Contact contact1=new Contact(1,"vicky","9848882399");
		Contact contact2=new Contact(2,"vamshi","8074335544");
		Contact contact3=new Contact(3,"Anish","9000898989");
        List<Contact> contacts=new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        List<Contact> result=contactService.listAll();
        assertEquals(contacts,result); 
        }
	
	@Test
	public void testFindById() {
		Contact contact=new Contact();
		contact.setId(2);
		contact.setName("vamshi");
		contact.setPhone("8074335544");
		Contact actualContact=contactService.listById(2);
		assertEquals(actualContact,contact);
	}
	
	@Test
	public void testDeleteById() {
		contactService.deleteById(3);
	    assertNull(contactService.listById(3));
		
		
		
	}
	@Test
	public void testSave() {
		Contact contact=new Contact();
		contact.setName("Raju");
		contact.setPhone("9020457294");
		Contact savedContact=contactService.save(contact);
		assertEquals(savedContact,contact);
	}
	
	
	
	
	
	
	
}
