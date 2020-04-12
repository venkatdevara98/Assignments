package com.venkat.updatedPhonebook.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.venkat.updatedPhonebook.dto.ContactDTO;
import com.venkat.updatedPhonebook.entity.Contact;
import com.venkat.updatedPhonebook.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
   
	private ContactService contactService;
	private ModelMapper modelMapper;
	
	
	
	@Autowired
	public ContactController(ContactService theContactService,ModelMapper theModelMapper) {
		contactService=theContactService;
		modelMapper=theModelMapper;
	}
	
	
	
	@GetMapping("/list")
	public String listContacts(Model theModel) {
		
		List<Contact> contactsEntity=contactService.findAll();
		
		List<ContactDTO> contacts=convertAllDTO(contactsEntity);
		
		theModel.addAttribute("contacts",contacts);
        
        return "list-contacts";
	}
	
	
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Contact contact=new Contact();
		theModel.addAttribute("contact",contact);
		return "contact-form";
	}
	
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("contactId") int theId,Model theModel) {
		Contact theContact=contactService.findById(theId);
		theModel.addAttribute("contact",theContact);
		return "contact-form";
	}
	
	
	
	@PostMapping("/save")
	public String saveContact(@Valid Contact contact,BindingResult bindingResult,Model theModel) {
		if(bindingResult.hasErrors())
			return "contact-form";
		if(checkContact(contact))
			return "contact-error-form";
		contactService.save(contact);
		theModel.addAttribute(contact);
		return "contact-saved";
	}
	
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("contactId") int theId,Model theModel) {
		Contact theContact=contactService.findById(theId);
		theModel.addAttribute("contact",theContact);
		contactService.deleteById(theId);
		return "contact-deleted";
	}
	
	@GetMapping("/searchById")
	public String findById(@RequestParam(value="contactId") int theId,Model theModel) {
		
	    try {
	    Contact contact=contactService.findById(theId);
	    List<Contact> contacts=Arrays.asList(contact);
		theModel.addAttribute("contacts",contacts);
	    }catch(RuntimeException exc) {
	    	return "id-not-found";
	    }
		return "list-contacts-id";
	}
	
	
	
	@RequestMapping("/showRequested")
	public String showRequested(@RequestParam(value="contactName") String contactName,Model theModel) {
		List<Contact> contacts=contactService.findAll();
		List<Contact> requestedContacts=new ArrayList<>();
		for(Contact contact:contacts) {
			if(contact.getName().equals(contactName))
				requestedContacts.add(contact);
		}
		if(requestedContacts.isEmpty())
			return "no-contact-found";
		theModel.addAttribute("contacts",requestedContacts);
		return "list-contacts-id";
	}
	
	
	
	@GetMapping("/listWithId")
	public String listContactsWithId(Model theModel) {
		
		List<Contact> contacts=contactService.findAll();
		theModel.addAttribute("contacts",contacts);
        
        return "list-contacts-id";
	}
	
	
	
	private ContactDTO convertToDto(Contact contact) {
	    ContactDTO contactDTO = modelMapper.map(contact, ContactDTO.class);
	    return contactDTO;
	}
	
	
	
	private List<ContactDTO> convertAllDTO(List<Contact> contacts){
		List<ContactDTO> contactsDTO=new ArrayList<>();
		for(Contact contact: contacts) {
			ContactDTO contactDTO=convertToDto(contact);
			contactsDTO.add(contactDTO);
		}
		return contactsDTO;
	}
	
	
	
	public boolean checkContact(Contact contact) {
		List<Contact> contacts=contactService.findAll();
		for(Contact presentContact:contacts) {
			if((contact.getId()==presentContact.getId()))
				return false;
		}
		for(Contact presentContact:contacts) {
			if(contact.getPhone().equals(presentContact.getPhone()))
				return true;
		}
		return false;
	}
}

