package com.example.demo.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class Config {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.primaryDatasource")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "app.secondaryDatasource")
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }
}
