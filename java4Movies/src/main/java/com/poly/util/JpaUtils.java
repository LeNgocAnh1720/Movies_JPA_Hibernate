package com.poly.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	public static EntityManagerFactory factory;
	
	static public EntityManager getEntityManager() {
		if(factory == null || factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("java4Movies");
		}
		return factory.createEntityManager();
	}
	
	//Ngắt kết nối
		static public void shutdown() {
			if(factory != null || factory.isOpen()) {
				factory.close();
			}
			factory = null;
		}
}
