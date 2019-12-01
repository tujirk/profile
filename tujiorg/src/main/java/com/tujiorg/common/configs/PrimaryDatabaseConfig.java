package com.tujiorg.common.configs;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
	    basePackages = "com.tujiorg.tuji", 
	    entityManagerFactoryRef = "db1EntityManager", 
	    transactionManagerRef = "db1TransactionManager"
	)
public class PrimaryDatabaseConfig {
	@Autowired
	private Environment env;
	
	@Bean(name="db1EntityManager")
	@Primary
	public LocalContainerEntityManagerFactoryBean db1EntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		HashMap<String, String> properties=new HashMap<>();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
		em.setJpaPropertyMap(properties);
		em.setDataSource(db1DataSource());
		em.setPersistenceUnitName("db1EntityManager");
		em.setPackagesToScan("com.tujiorg");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return em;
	}

	@Primary
	@Bean(name="db1")
	public DataSource db1DataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("driver.class.name"));
		dataSource.setUrl(env.getProperty("db1.datasource.url"));
		dataSource.setUsername(env.getProperty("db1.datasource.username"));
		dataSource.setPassword(env.getProperty("db1.datasource.password"));
		return dataSource;
	}
	
	@Primary
	@Bean(name="db1TransactionManager")
	public PlatformTransactionManager db1TransactionManager() {
		JpaTransactionManager transManager=new JpaTransactionManager();
		transManager.setEntityManagerFactory(db1EntityManager().getObject());
		return transManager;
	}
	
}
