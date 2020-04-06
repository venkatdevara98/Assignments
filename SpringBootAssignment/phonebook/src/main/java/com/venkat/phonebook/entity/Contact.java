package com.venkat.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="contacts")
public class Contact {
      
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;

	public Contact() {
		
	}
	public Contact(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override 
	public boolean equals(Object obj) 
	{ 
		if (obj == this) 
		  { 
			return true; 
		  } 
		if (obj == null || obj.getClass() != this.getClass()) { 
			return false; 
			} 
		Contact thisContact = (Contact) obj; 
		if(thisContact.id!=this.id)
			return false;
		if(!(thisContact.name).equals(this.name))
			return false;
		if(!(thisContact.phone).equals(this.phone))
			return false;

		return true;
	}
	
	@Override
	public String toString() {
		return id+name+phone;
	}
}
