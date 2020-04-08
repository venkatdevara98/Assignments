package com.venkat.updatedPhonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;


@Entity
@Table(name="contacts")
public @Data class Contact {
      
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private int id;
	
	@NotNull(message="Name cannot be empty")
	@Size(min=1,max=16,message="Name must be between 1 and 16 characters")
	@Pattern(regexp="^[a-zA-Z]*$",message="Name must contain only letters")
	@Column(name="name")
	private String name;
	
	@NotNull(message="Phone number cannot be empty")
	@Size(min=10,max=10,message="Phone number must be of 10 digits only")
	@Pattern(regexp="^[1-9]{1}[0-9]{9}",message="Phone number must contain only digits")
	@Column(name="phone")
	private String phone;

	public Contact(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
    public Contact() {
    	
    }
}
