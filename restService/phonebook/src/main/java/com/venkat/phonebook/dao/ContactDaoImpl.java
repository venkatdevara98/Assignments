package com.venkat.phonebook.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.venkat.phonebook.entity.*;



@Repository
public class ContactDaoImpl implements ContactDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Contact> listAll() {
          Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Contact> theQuery =
				currentSession.createQuery("from Contact", Contact.class);
		

		List<Contact> contacts = theQuery.getResultList();
			
		return contacts;
	}

	@Override
	public Contact listById(int thisId) {
				Session currentSession = entityManager.unwrap(Session.class);
				
				Contact theContact =
						currentSession.get(Contact.class, thisId);
				
				return theContact;
	}

	@Override
	public void save(Contact thisContact) {
		
        Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(thisContact);
		
	}

	@Override
	public void deleteById(int thisId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Contact> theQuery = 
				currentSession.createQuery(
						"delete from Contact where id=:contactId");
		theQuery.setParameter("contactId", thisId);
		
		theQuery.executeUpdate();
		
	}



}
