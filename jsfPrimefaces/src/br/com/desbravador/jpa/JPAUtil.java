package br.com.desbravador.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Treinamento");
	
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
}
