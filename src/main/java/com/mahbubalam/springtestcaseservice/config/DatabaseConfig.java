package com.mahbubalam.springtestcaseservice.config;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    private final Environment environment;

    public DatabaseConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(DataSource dataSource) {
        return hibernateProperties -> {
            try (Connection connection = dataSource.getConnection()) {
                DatabaseMetaData metaData = connection.getMetaData();
                String catalog = connection.getCatalog();
                boolean databaseExists = metaData.getCatalogs().next() || catalog != null;
                if (databaseExists) {
                    hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "update");
                } else {
                    hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "create");
                }
            } catch (SQLException e) {
                throw new RuntimeException("Failed to determine if database exists", e);
            }
        };
    }
}
