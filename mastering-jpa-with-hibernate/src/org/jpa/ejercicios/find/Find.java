package org.jpa.ejercicios.find;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jpa.model.Customer;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();

		Customer c1 = em.find(Customer.class, 1L);
		Customer c2 = em.find(Customer.class, 2L);
		Customer c3 = em.find(Customer.class, 3L);

		System.out.println("c1:" + c1);
		System.out.println("c2:" + c2);
		System.out.println("c3:" + c3);
	}
}
