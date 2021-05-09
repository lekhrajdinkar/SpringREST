package com.lekhraj.sb.configuration.database;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("classpath:database-and-hibernate.properties")
public class HibernateConfig 
{
	@Autowired private Environment env;
	@Autowired private DataSource ds;
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
		System.out.println("-- Ext cong : Creating bean -> LocalSessionFactoryBean ");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(ds);
        sessionFactory.setHibernateProperties(hibernateProperties());
        // sessionFactory.setPackagesToScan({""});
        System.out.println(sessionFactory + "\n"+ sessionFactory.toString());
        return sessionFactory;
    }
	
	private final Properties hibernateProperties() {
    	final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        return hibernateProperties;
    }

    //@Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
    
    
		
}

/*
 manually inject LocalSessionFactoryBean inside Repo 
 
 */
