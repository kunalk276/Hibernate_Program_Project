package com.hibernatequery;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			Properties settings=new Properties();
			settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/empdept");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "ADI#27#nal");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			
			Configuration cfg = new Configuration();
			cfg.setProperties(settings);

			// Add annotated classes
			cfg.addAnnotatedClass(com.hibernatequery.Employee.class);
			// Add other annotated classes 

			// Build ServiceRegistry
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			    .applySettings(cfg.getProperties())
			    .build();

			// Build SessionFactory
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);

			return sessionFactory;
			
		}
		return sessionFactory;
		
	}
	
}
