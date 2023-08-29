package com.example.demo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "drEntityManagerFactory", transactionManagerRef = "drTransactionManager", basePackages = {
		"com.example.demo.dr.repository" })
public class DRDataSourceConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.dr-datasource")
	public DataSourceProperties drDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "drDataSource")
	public DataSource drDataSource() {
		return drDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean(name = "drJdbcTemplate")
	public JdbcTemplate drJdbcTemplate() {
		return new JdbcTemplate(drDataSource());
	}

	@Bean(name = "drEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean drEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(drDataSource()).packages("com.example.demo.dr.entity").persistenceUnit("dr").build();
	}

	@Bean(name = "drTransactionManager")
	public JpaTransactionManager drTransactionManager(
			@Qualifier("drEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

//	@Bean(name = "drDataSourceLiquibase")
//	public SpringLiquibase drDataSourceLiquibase(@Qualifier("drDataSource") DataSource dataSource,
//			@Value("${spring.datasource.dr-datasource.liquibase-change-log}") String changeLog) {
//		SpringLiquibase liquibase = new SpringLiquibase();
//		liquibase.setDataSource(dataSource);
//		liquibase.setChangeLog(changeLog);
//		return liquibase;
//	}

}
