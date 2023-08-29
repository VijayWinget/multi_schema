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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.auto.repository", entityManagerFactoryRef = "autoEntityManagerFactory", transactionManagerRef = "autoTransactionManager")
public class AutoDataSourceConfig {
	@Primary
	@Bean
	@ConfigurationProperties("spring.datasource.auto-datasource")
	public DataSourceProperties autoDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean(name = "autoDataSource")
	public DataSource autoDataSource() {
		return autoDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Primary
	@Bean(name = "autoJdbcTemplate")
	public JdbcTemplate autoJdbcTemplate() {
		return new JdbcTemplate(autoDataSource());
	}

	@Primary
	@Bean(name = "autoEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean autoEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(autoDataSource()).packages("com.example.demo.auto.entity").persistenceUnit("auto")
				.build();
	}

	@Primary
	@Bean(name = "autoTransactionManager")
	public JpaTransactionManager autoTransactionManager(
			@Qualifier("autoEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

//	@Primary
//	@Bean(name = "autoDataSourceLiquibase")
//	public SpringLiquibase autoDataSourceLiquibase(@Qualifier("autoDataSource") DataSource dataSource,
//			@Value("${spring.datasource.auto-datasource.liquibase-change-log}") String changeLog) {
//		SpringLiquibase liquibase = new SpringLiquibase();
//		liquibase.setDataSource(dataSource);
//		liquibase.setChangeLog(changeLog);
//		return liquibase;
//	}

}