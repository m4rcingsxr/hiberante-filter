package com.example;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.reactive.mutiny.Mutiny;
import org.hibernate.reactive.provider.ReactiveServiceRegistryBuilder;

import java.util.List;

import static org.hibernate.cfg.JdbcSettings.FORMAT_SQL;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;
import static org.hibernate.cfg.JdbcSettings.JAKARTA_JDBC_PASSWORD;
import static org.hibernate.cfg.JdbcSettings.JAKARTA_JDBC_URL;
import static org.hibernate.cfg.JdbcSettings.JAKARTA_JDBC_USER;
import static org.hibernate.cfg.JdbcSettings.SHOW_SQL;

@UtilityClass
public class HibernateUtil {

    private static final List<Class<?>> annotatedClasses = List.of(User.class, Filters.class, Address.class);

    @Getter
    private static final Mutiny.SessionFactory sessionFactory = initializeSessionFactory();

    private static Mutiny.SessionFactory initializeSessionFactory() {
        Configuration configuration = getConfiguration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());

        for (Class<?> clazz : annotatedClasses) {
            configuration.addAnnotatedClass(clazz);
        }

        return configuration.buildSessionFactory(
                new ReactiveServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build()
        ).unwrap(Mutiny.SessionFactory.class);
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setProperty(JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/quarkus");
        configuration.setProperty(JAKARTA_JDBC_USER, "quarkus");
        configuration.setProperty(JAKARTA_JDBC_PASSWORD, "quarkus");
        configuration.setProperty(SHOW_SQL, "true");
        configuration.setProperty(FORMAT_SQL, "true");
        configuration.setProperty(HIGHLIGHT_SQL, "true");
        return configuration;
    }

}

