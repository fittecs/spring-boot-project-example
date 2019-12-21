package com.fittecs.sbpe.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DefaultConfig {
  private static String PROP_DB_DRIVER_CLASS = "spring.datasource.driverClassName";
  private static String PROP_DB_URL = "spring.datasource.url";
  private static String PROP_DB_USER = "spring.datasource.username";
  private static String PROP_DB_PASS = "spring.datasource.password";

  @Autowired private Environment env;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty(PROP_DB_DRIVER_CLASS));
    dataSource.setUrl(env.getProperty(PROP_DB_URL));
    dataSource.setUsername(env.getProperty(PROP_DB_USER));
    dataSource.setPassword(env.getProperty(PROP_DB_PASS));
    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource());
    em.setPackagesToScan("com.sweng.giflib.model");

    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);

    return em;
  }
}
