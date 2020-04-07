package com.venkat.updatedPhonebook.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doReturn;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.hibernate.criterion.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.junit.MockitoJUnitRunner;

import com.venkat.updatedPhonebook.dao.ContactRepository;
import com.venkat.updatedPhonebook.entity.Contact;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {
	
    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactService;

    @Test
    public void testFindAll() {
       
        Contact contact=new Contact(6,"ray","7182917262");
        List<Contact> expectedContacts = Arrays.asList(contact);

        doReturn(expectedContacts).when(contactRepository).findAll();

        List<Contact> actualContacts = contactService.findAll();

        
        assertThat(actualContacts).isEqualTo(expectedContacts);
    }
    
    @Test 
    public void testFindById() {
    	Contact contact=new Contact(7,"penber","8291281929");
    	Mockito.when(contactRepository.findById(contact.getId())).thenReturn(Optional.of(contact));
    	Contact actualContact=contactService.findById(contact.getId());
    	assertThat(actualContact).isEqualTo(contact);
    }
    
    @Test
    public void testDelete() {
    	Contact contact=new Contact(8,"tokio","8392732819");
    	contactService.deleteById(contact.getId());
    	verify(contactRepository,times(1)).deleteById(contact.getId());
    }
    
    @Test
    public void testSave() {
    	Contact contact=new Contact(9,"denver","7281931731");
    	contactService.save(contact);
    	verify(contactRepository,times(1)).save(contact);
    }
}
