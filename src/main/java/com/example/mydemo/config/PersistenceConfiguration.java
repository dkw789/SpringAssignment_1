//package com.example.mydemo.config;
//import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
////@PropertySource({"classpath:persistence-multiple-db-boot.properties"})
//@EnableJpaRepositories(basePackages = "com.example.mydemo.model", entityManagerFactoryRef = "userEntityManager", transactionManagerRef = "userTransactionManager")
//public class PersistenceConfiguration {
//	@Bean
//	@ConfigurationProperties(prefix="spring.datasource")
//	@Primary
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean
//	@ConfigurationProperties(prefix="datasource.flyway")
//	@FlywayDataSource
//	public DataSource flywayDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//}
