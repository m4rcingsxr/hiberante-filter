package com.example;

import org.hibernate.reactive.mutiny.Mutiny;
import org.junit.jupiter.api.Test;

import java.util.List;

class FilterTest {

    @Test
    void filterTest1() {
        Mutiny.SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        List<User> users = sessionFactory.withTransaction(session -> {
            session.enableFilter("stringEquals")
                    .setParameter("field", User_.LASTNAME)
                    .setParameter("value", "Doe");

            return session.createQuery("from User", User.class).getResultList();
        }).await().indefinitely();

    }


    @Test
    void filterTest2() {
        Mutiny.SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        List<Address> addresses = sessionFactory.withTransaction(session -> {
            session.enableFilter("stringEquals")
                    .setParameter("field", "street")
                    .setParameter("value", "123");

            return session.createQuery("from Address", Address.class).getResultList();
        }).await().indefinitely();
    }

    @Test
    void filterTest3() {
        Mutiny.SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        List<User> users = sessionFactory.withTransaction(session -> {
            session.enableFilter("stringEquals")
                    .setParameter("field", User_.NAME)
                    .setParameter("value", "Doe")
                    .setParameter("field", User_.LASTNAME)
                    .setParameter("value", "Doe");

            return session.createQuery("from User", User.class).getResultList();
        }).await().indefinitely();
    }

}

