package org.jpa.ejercicios.update;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.enums.CustomerStatus;
import org.jpa.model.Customer;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		// Se crean dos clientes y se persisten
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
		
		System.out.println("customer c1: " + c1);
		System.out.println("customer c2: " + c2);
		
		// se actualizan los registros
		Customer talavera = em.find(Customer.class, 1L);
		talavera.setFirstname("Talavera");
		talavera.setLastname("Juarez");
		em.persist(talavera);
		
		Customer sandra = em.find(Customer.class, 4L);
		sandra.setFirstname("Sandra");
		em.persist(sandra);
		
		em.getTransaction().commit();
		
		
		
		
	}

}
