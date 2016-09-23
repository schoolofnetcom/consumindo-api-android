package com.schoolofnet.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
	
	public static final SessionFactory SESSION_FACTORY = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch(Throwable ex) {
			ex.getStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	} 
	
	public static SessionFactory getSession() {
		return SESSION_FACTORY;
	}
	
	public static void close() {
		getSession().close();
	}
}
