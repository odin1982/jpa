package org.jpa.config;

import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.enums.CustomerStatus;
import org.jpa.model.Customer;

public class TestTransient {
	public static void main(String[] args) {
		//persistence-unit = mastering-jpa-with-hibernate
		//MYSQL
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mastering-jpa-with-hibernate");
		
		//ORACLE 11G
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer customer1 = new Customer();
		customer1.setFirstname("Odin");
		customer1.setLastname("Araujo");
		//APUNTES - Calendar.getInstance() - Get today
		customer1.setBirthdate(Calendar.getInstance());
		customer1.setRegDate(Calendar.getInstance());
		customer1.setRegDateLocalDate(LocalDate.now());
		customer1.setStatus(CustomerStatus.ACTIVE);
		
		Customer customer2 = new Customer();
		customer2.setFirstname("Amaya");
		customer2.setLastname("Araujo");
		customer2.setBirthdate(Calendar.getInstance());
		customer2.setRegDate(Calendar.getInstance());
		customer2.setRegDateLocalDate(LocalDate.now());
		customer2.setStatus(CustomerStatus.INACTIVE);
		
		Customer customer3 = new Customer();
		customer3.setFirstname("Sandra");
		customer3.setLastname("Hernandez");
		customer3.setBirthdate(Calendar.getInstance());
		customer3.setRegDate(Calendar.getInstance());
		customer3.setRegDateLocalDate(LocalDate.now());
		customer3.setStatus(CustomerStatus.ACTIVE);
		
		em.persist(customer1);
		em.persist(customer2);
		em.persist(customer3);
		
		Customer customer = em.find(Customer.class, 1L);
		System.out.println("customer: " + customer);
		
		em.getTransaction().commit();
	}
}
