package com.venkat.updatedPhonebook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.venkat.updatedPhonebook.entity.Contact;
import com.venkat.updatedPhonebook.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
   
	private ContactService contactService;
	
	@Autowired
	public ContactController(ContactService theContactService) {
		contactService=theContactService;
	}
	
	@GetMapping("/list")
	public String listContacts(Model theModel) {
		List<Contact> contacts=contactService.findAll();
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
	public String saveContact(@ModelAttribute("contact") Contact theContact) {
		contactService.save(theContact);
		return "redirect:/contacts/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("contactId") int theId) {
		contactService.deleteById(theId);
		return "redirect:/contacts/list";
	}
}