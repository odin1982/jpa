package org.jpa.persist;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.enums.CustomerStatus;
import org.jpa.model.Customer;

public class Persist {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		Customer c1 = new Customer();
		c1.setFirstname("odin");
		c1.setLastname("araujo");
		c1.setBirthdate(LocalDate.of(1982,Month.APRIL,10));
		c1.setStatus(CustomerStatus.ACTIVE);
		c1.setRegDate(LocalDateTime.now());
		
		em.getTransaction().begin();
		em.persist(c1);
		em.getTransaction().commit();
		
		System.out.println("customer id: " + c1.getId());
		
	}

}
