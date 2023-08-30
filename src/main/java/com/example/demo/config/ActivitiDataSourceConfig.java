package com.example.demo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.service.CustomUserDetailsService;
	
	@Configuration
	@EnableJpaRepositories(basePackages = "com.example.demo.ac.repository", entityManagerFactoryRef = "acEntityManagerFactory", transactionManagerRef = "acTransactionManager")
	public class ActivitiDataSourceConfig {
	
		@Bean
		@ConfigurationProperties("spring.datasource.ac-datasource")
		public DataSourceProperties acDataSourceProperties() {
			return new DataSourceProperties();
		}
	
		@Bean(name = "acDataSource")
		public DataSource acDataSource() {
			return acDataSourceProperties().initializeDataSourceBuilder().build();
		}
	
		@Bean(name = "acEntityManagerFactory")
		public LocalContainerEntityManagerFactoryBean acEntityManagerFactory(EntityManagerFactoryBuilder builder) {
			return builder.dataSource(acDataSource()).packages("com.example.demo.ac.entity").persistenceUnit("ac").build();
		}
	
		@Bean(name = "acTransactionManager")
		public JpaTransactionManager acTransactionManager(
				@Qualifier("acEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
			return new JpaTransactionManager(entityManagerFactory);
		}
		
		@Bean
		@Primary
		public UserDetailsService UserDetailsService() {
			return new CustomUserDetailsService();
		}
		
	}
	
	


//@Bean
//public ProcessEngine processEngine() {
//    ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
//            .setJdbcUrl("jdbc:mysql://localhost:3306/activiti?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull")
//            .setJdbcUsername("root")
//            .setJdbcPassword("")
//            .setJdbcDriver("com.mysql.cj.jdbc.Driver")
//            .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
//
//    return processEngineConfiguration.buildProcessEngine();
//}