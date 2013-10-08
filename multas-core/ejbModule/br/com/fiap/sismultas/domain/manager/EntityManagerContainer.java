package br.com.fiap.sismultas.domain.manager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Classe que encapsula e provê o Entity Manager para todas as entidades do sistema.
 * 
 * @author caio-pereira
 *
 */
public class EntityManagerContainer {

	/** variável estática: EntityManagerFactory */
	private static EntityManagerFactory entityManagerFactory;
	
	/**
	 * 
	 * Provê o entity manager
	 * 
	 * @return
	 */
	protected static EntityManager getEntityManager() {
	
		//Verifica se o entity manager factory é nulo. Se sim, faz o lookup no jboss
		if (entityManagerFactory == null) {
		
			try {
				Context ctx = new InitialContext();
				entityManagerFactory =
						(EntityManagerFactory) ctx.lookup("java:jboss/sis-multas-EntityManagerFactory");
			} catch (Exception ex) {}
					
		}
		
		// Retorna o entity manager.
		return entityManagerFactory.createEntityManager();
		
	}
	
	public void persist() {
		getEntityManager().persist(this);
	}
	
	public void update() {
		getEntityManager().merge(this);
	}
		
}
