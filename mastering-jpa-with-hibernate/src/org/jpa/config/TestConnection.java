package org.jpa.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestConnection {
	public static void main(String[] args) {
		//persistence-unit = mastering-jpa-with-hibernate
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mastering-jpa-with-hibernate");
		EntityManager em = factory.createEntityManager();
	}
}
