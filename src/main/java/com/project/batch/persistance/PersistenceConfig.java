package com.project.batch.persistance;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfig {

	/*@Bean
	@ConfigurationProperties(prefix="spring.data.cassandra")
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();

	}*/
}

