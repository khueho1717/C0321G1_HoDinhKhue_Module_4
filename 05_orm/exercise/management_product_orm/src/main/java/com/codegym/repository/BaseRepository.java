package com.codegym.repository;

import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

public class BaseRepository {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
