package com.karatesan.FullStackApp.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Datasource {

    // ta anotacja injectuje dane z application.yml (albo properties) zaczynajace sie od app.datasource.
    // Normalnie trzeba by recznie to dodawac w tym builderze
    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikariDataSource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}
