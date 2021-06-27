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
		customer1.setFirstname("Odin");
		customer1.setLastname("Araujo");
		
		Customer customer2 = new Customer();
		customer2.setFirstname("Amaya");
		customer2.setLastname("Araujo");
		
		Customer customer3 = new Customer();
		customer3.setFirstname("Sandra");
		customer3.setLastname("Hernandez");
		
		em.persist(customer1);
		em.persist(customer2);
		em.persist(customer3);
		
		em.getTransaction().commit();
	}
}
