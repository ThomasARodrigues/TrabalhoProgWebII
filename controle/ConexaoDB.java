package br.furb.JPATutorial.controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoDB {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	private ConexaoDB() {
	}
	
	public synchronized static EntityManager getInstance() {
		if (entityManager == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
			entityManager = entityManagerFactory.createEntityManager();
		}
		
		return entityManager;
	}
	
}
