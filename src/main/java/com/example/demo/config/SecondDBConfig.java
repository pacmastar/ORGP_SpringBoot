package com.example.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * Spring configuration of the "PostgreSQL" database.
 *
 * @author Radouane ROUFID.
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondaryTransactionManager",
        basePackages = "com.example.demo.service.secondary"
)
public class SecondDBConfig {
    @Value("${app.secondaryDatasource.url}")
    private String url;
    @Value("${app.secondaryDatasource.username}")
    private String username;
    @Value("${app.secondaryDatasource.password}")
    private String password;
    @Value("${app.secondaryDatasource.driver}")
    private String driver;


    @Bean
    public DataSource secondDataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        return new HikariDataSource(config);
    }

    @Bean
    public PlatformTransactionManager secondaryTransactionManager(){
        return new JpaTransactionManager(secondaryEntityManagerFactory().getObject());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(secondDataSource());
        factory.setPackagesToScan("com.example.demo.domain.secondary");
        return factory;
    }
}