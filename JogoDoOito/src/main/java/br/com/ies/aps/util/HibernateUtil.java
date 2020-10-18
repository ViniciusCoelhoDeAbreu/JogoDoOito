package br.com.ies.aps.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.com.ies.aps.entity.JogadaCasaEntity;
import br.com.ies.aps.entity.JogadaEntity;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static void carregaSessionFactory() {
		if (sessionFactory == null) {
			try {

				Configuration configuration = new Configuration();
				Properties settings = new Properties();

				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/faculdade");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "postgres");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				settings.put(Environment.SHOW_SQL, "false");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(JogadaEntity.class);
				configuration.addAnnotatedClass(JogadaCasaEntity.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

}
