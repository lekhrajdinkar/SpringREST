package com.lekhraj.sb.configuration.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:database-and-hibernate.properties")
public class DataSourceConfig {
	
	@Autowired
    private Environment env;
    
    @Bean
    public DataSource getDataSource() {
    	System.out.println("-- env :: h2-hibernate.properties-- \n"+ env);
    	System.out.println("-- Ext cong : Creating bean -> DataSource ");
    	System.out.println("jdbc.url " + env.getProperty("jdbc.url"));
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(env.getProperty("jdbc.driverClassName"));
        dataSourceBuilder.url(env.getProperty("jdbc.url"));
        dataSourceBuilder.username(env.getProperty("jdbc.user"));
        dataSourceBuilder.password(env.getProperty("jdbc.pass"));
        DataSource retval = dataSourceBuilder.build();
        System.out.println(retval + "\n"+ retval.toString());
        return retval;
    }
    
    // JDBD connection pool
    // @Bean
    public DataSource dataSource() {
    	
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
        return dataSource;
    }
}

/*
 DS is interface has several implementation bt jdbc, hikari, etc
 
 */
 
