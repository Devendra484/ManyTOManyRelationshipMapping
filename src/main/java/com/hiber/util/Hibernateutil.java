package com.hiber.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.hiber.Entity.Actors;
import com.hiber.Entity.Movies;

public class Hibernateutil {

	 private static final SessionFactory sessionFactory = buildSessionFactory();

	    private static SessionFactory buildSessionFactory() {
	        try {
	            return new Configuration().configure().addAnnotatedClass(Actors.class).addAnnotatedClass(Movies.class).buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

	    public static void shutdown() {
	        getSessionFactory().close();
	    }
	
	
}
