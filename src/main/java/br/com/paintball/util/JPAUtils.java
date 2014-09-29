package br.com.paintball.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	public static EntityManager createEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("default");
		return factory.createEntityManager();
	}
}
