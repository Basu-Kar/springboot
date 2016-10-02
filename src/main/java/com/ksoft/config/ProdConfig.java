package com.ksoft.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory", 
        basePackages = { "com.ksoft.product.repositories" },
        transactionManagerRef = "productEntityManager")
public class ProdConfig {
	
	 	@Bean
	    @Primary
	    public LocalContainerEntityManagerFactoryBean productEntityManager() {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(productDataSource());
	        em.setPackagesToScan(new String[] { "com.ksoft.product.models" });
	 
	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        em.setJpaVendorAdapter(vendorAdapter);
	        HashMap<String, Object> properties = new HashMap<String, Object>();
	        properties.put("hibernate.hbm2ddl.auto", "");
	        properties.put("hibernate.dialect","");
	        em.setJpaPropertyMap(properties);
	 
	        return em;
	    }
	 
	    @Primary
	    @Bean
	    public DataSource productDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.postgresql.Driver");
	        dataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");
	        dataSource.setUsername("postgres");
	        dataSource.setPassword("postgres");
	 
	        return dataSource;
	    }
	 
	    @Primary
	    @Bean
	    public PlatformTransactionManager productTransactionManager() {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(productEntityManager().getObject());
	        return transactionManager;
	    }
}
