package org.jpa.ejercicios._03.relaciones.manyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.enums.CustomerStatus;
import org.jpa.enums.Status;
import org.jpa.model.Customer;
import org.jpa.model.Order;

public class ManyToOneSample {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Customer c1 = new Customer();
		c1.setFirstname("guillermo");
		c1.setLastname("araujo");
		c1.setBirthdate(LocalDate.of(1982,Month.APRIL,10));
		c1.setStatus(CustomerStatus.ACTIVE);
		c1.setRegDate(LocalDateTime.now());
		
		Customer c2 = new Customer();
		c2.setFirstname("francisco");
		c2.setLastname("hernandez");
		c2.setBirthdate(LocalDate.of(1983,Month.SEPTEMBER,5));
		c2.setStatus(CustomerStatus.ACTIVE);
		c2.setRegDate(LocalDateTime.now());
		
		em.persist(c1);
		em.persist(c2);
		
		Customer c11 = em.find(Customer.class, 1L);
		Order order = new Order();
		order.setCustomer(c11);
		order.setRegDate(LocalDateTime.now());
		order.setStatus(Status.ACTIVE);
		order.setTotal(200.25);
		em.persist(order);
		em.getTransaction().commit();
	}

}
