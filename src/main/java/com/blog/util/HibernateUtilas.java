package com.blog.util;

import java.lang.module.Configuration;

import org.hibernate.SessionFactory;

public class HibernateUtilas {

		private static SessionFactory sessionFactory = null;

		public static SessionFactory getsessionfactory() {
			org.hibernate.cfg.Configuration cfg =new org.hibernate.cfg.Configuration();
			cfg.configure();
			sessionFactory = cfg.buildSessionFactory();
			return sessionFactory;
		}
	   public static void closeFactory() {
		   if(sessionFactory!=null) {
			   sessionFactory.close();
		   }
	   }
	}




