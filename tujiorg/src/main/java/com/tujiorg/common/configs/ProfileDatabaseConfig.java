package com.tujiorg.common.configs;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages="com.tujiorg.products.profile",
		entityManagerFactoryRef="dbProfileEntityManager",
		transactionManagerRef="dbProfileTransactionManage"
		)
public class ProfileDatabaseConfig  {
	@Autowired
	Environment env;
	
	@Bean(name="dbProfileEntityManager")
	public LocalContainerEntityManagerFactoryBean dbProfileEntityManager() {
		LocalContainerEntityManagerFactoryBean em= new LocalContainerEntityManagerFactoryBean();
		HashMap<String, String> properties= new HashMap<>();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
		em.setJpaPropertyMap(properties);
		em.setDataSource(dbProfileDataSource());
		em.setPersistenceUnitName("dbProfileEntityManager");
		em.setPackagesToScan("com.tujiorg");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return em;
	}
	
	@Bean(name="dbProfile")
	DataSource dbProfileDataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("driver.class.name"));
		dataSource.setUrl(env.getProperty("db.profile.datasource.url"));
		dataSource.setUsername(env.getProperty("db.profile.datasource.username"));
		dataSource.setPassword(env.getProperty("db.profile.datasource.password"));
		return dataSource;
	}
	
	@Bean(name="dbProfileTransactionManage")
	PlatformTransactionManager dbProfileTransactionManage() {
		JpaTransactionManager transManager= new JpaTransactionManager();
		transManager.setEntityManagerFactory(dbProfileEntityManager().getObject());
		return transManager;
	}
	
}
