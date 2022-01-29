package com.bsoftgroup.springcloudmssecurity.core.dao.util;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

	@Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
	public DataSourceProperties dataSourceProperties() {
		 return new DataSourceProperties();
		
	}
	
	@Bean
    @Primary
    @ConfigurationProperties("spring.datasource.configuration")
    public DataSource dataSource() {
		
        return dataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }	

}
