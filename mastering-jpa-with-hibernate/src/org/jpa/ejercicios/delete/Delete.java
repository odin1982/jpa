package org.jpa.ejercicios.delete;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.model.Customer;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, 6L);
		em.remove(customer);
		em.getTransaction().commit();
		
		
	}
}
