package org.jpa.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.model.Customer;

public class TestConnection {
	public static void main(String[] args) {
		//persistence-unit = mastering-jpa-with-hibernate
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mastering-jpa-with-hibernate");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer customer1 = new Customer();
		customer1.setId(1L);
		customer1.setFirstname("Odin");
		customer1.setLastname("Araujo");
		
		em.persist(customer1);
		
		em.getTransaction().commit();
	}
}
