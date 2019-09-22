package com.tirmizee.core.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
public class RepositoryConfig {
	
	/*
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.tirmizee.entities");
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory.getObject());
		return transactionManager;
	}	*/
	
	
	@Bean
	@SuppressWarnings("unchecked")
	public Map<String, String> springQuery(){
		Map<String, String> map = null;
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-map-query.xml")) {
			map = (Map<String, String>) context.getBean("someId");
		}
		return map;
	}
	
}
