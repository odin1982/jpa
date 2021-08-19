package org.jpa.ejercicios.jpql.typedQuery;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.jpa.model.Customer;

public class TypedQuerySample {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.firstname = :firstName",Customer.class);
		query.setParameter("firstName", "Amaya");
		List<Customer> customers = query.getResultList();
		customers.stream().forEach(c -> System.out.println(c));
	}
}
