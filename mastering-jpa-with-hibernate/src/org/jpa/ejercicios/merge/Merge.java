package org.jpa.ejercicios.merge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.enums.CustomerStatus;
import org.jpa.model.Customer;

public class Merge {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer c1 = new Customer();
		c1.setId(1L);
		c1.setFirstname("Giovanni");
		c1.setLastname("dos Santos");
		c1.setBirthdate(LocalDate.of(1992,Month.APRIL,25));
		c1.setStatus(CustomerStatus.ACTIVE);
		c1.setRegDate(LocalDateTime.now());
		
		em.merge(c1);
		em.getTransaction().commit();
		
		System.out.println("customer id: " + c1.getId());
	}

}
