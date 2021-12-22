package com.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.app.models.Diplome;
import com.app.models.Entreprise;
import com.app.models.Poste;
import com.app.models.Profil;
import com.app.models.Qualite;
import com.app.models.Tache;

public class HibernateUtils {

	private static final SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static {
		Configuration config = new Configuration();
		config.configure();

		config.addAnnotatedClass(Tache.class);
		config.addAnnotatedClass(Entreprise.class);
		config.addAnnotatedClass(Qualite.class);
		config.addAnnotatedClass(Diplome.class);
		config.addAnnotatedClass(Profil.class);
		config.addAnnotatedClass(Poste.class);

		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
