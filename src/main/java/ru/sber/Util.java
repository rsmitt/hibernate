package ru.sber;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.sber.entity.Company;

public class Util {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Company.class);

        return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
