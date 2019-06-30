package com.sutiboot.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sutiboot.domain.Department;
import com.sutiboot.domain.Employee;

public class HibernateUtil {
	  private static StandardServiceRegistry registry;
	  private static SessionFactory sessionFactory;

	  public static SessionFactory getSessionFactory() {
	    if (sessionFactory == null) {
	      try {
	        StandardServiceRegistryBuilder registryBuilder = 
	            new StandardServiceRegistryBuilder();

	        Map<String, String> settings = new HashMap<>();
	        settings.put("hibernate.connection.driver_class", "org.h2.Driver");
	        settings.put("hibernate.connection.url", "jdbc:h2:mem:testdb");
	        settings.put("hibernate.connection.username", "sa");
	        settings.put("hibernate.connection.password", "");
	        settings.put("hibernate.show_sql", "true");
	        settings.put("hibernate.hbm2ddl.auto", "update");
	        settings.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

	        registryBuilder.applySettings(settings);

	        registry = registryBuilder.build();

	        MetadataSources sources = new MetadataSources(registry)
	                .addAnnotatedClass(Employee.class)
	                .addAnnotatedClass(Department.class);
	        Metadata metadata = sources.getMetadataBuilder().build();

	        sessionFactory = metadata.getSessionFactoryBuilder().build();
	      } catch (Exception e) {
	        System.out.println("SessionFactory creation failed");
	        if (registry != null) {
	          StandardServiceRegistryBuilder.destroy(registry);
	        }
	      }
	    }
	    return sessionFactory;
	  }

	  public static void shutdown() {
	    if (registry != null) {
	      StandardServiceRegistryBuilder.destroy(registry);
	    }
	  }
	}