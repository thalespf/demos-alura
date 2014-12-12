/**
 * 
 */
package com.thalespf.demos.livraria.dao;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class JPAUtil {
	
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("persistenceUnit", configDataBase());

	private JPAUtil() {
	}
	
	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
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
