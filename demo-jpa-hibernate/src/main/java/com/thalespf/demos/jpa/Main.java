package com.thalespf.demos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thalespf.demos.jpa.domain.Editora;


public class Main {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

	public Main() {
	}
	
	public static void main(String[] args) {
		Map<String, String> properties = configDataBase();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit", properties);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		logger.info("Primeira find");
		Editora editora = entityManager.find(Editora.class, 1L);
		
		logger.info("Segundo find");
		editora = entityManager.find(Editora.class, 1L);
		
		//save(entityManager);
		entityManager.close();
	}

	private static void save(EntityManager entityManager) {
		Editora editora = new Editora();
		editora.setNome("K19 - Livros");
		editora.setEmail("k19livros@gmail.com");
		
		entityManager.getTransaction().begin();
		entityManager.persist(editora);
		logger.debug("Editora ID = " + editora.getId());
		entityManager.getTransaction().commit();
	}

	private static HashMap<String, String> configDataBase() {
		HashMap<String,String> properties = new HashMap<String, String>();
		
		properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost/livraria");
		properties.put("javax.persistence.jdbc.user", "thales");
		properties.put("javax.persistence.jdbc.password", "meupc!1setembro");
		
		return properties;
	}

}
