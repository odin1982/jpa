package org.jpa.ejercicios.jpql.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jpa.model.Customer;

public class QuerySample {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT c FROM Customer c");
		List<Customer> customersList = query.getResultList();
		customersList.stream().forEach(c -> System.out.println(c));
		
		System.out.println();
		Query query2 = em.createQuery("SELECT c FROM Customer c WHERE c.firstname = :firstName");
		query2.setParameter("firstName", "Odin");
		List customersWithName = query2.getResultList();
		customersWithName.stream().forEach(c -> System.out.println(c));
		
	}
}
