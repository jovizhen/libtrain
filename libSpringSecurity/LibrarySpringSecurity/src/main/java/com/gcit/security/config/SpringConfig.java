package com.gcit.security.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class SpringConfig
{

	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate temp = new JdbcTemplate();
		temp.setDataSource(dataSource());
		return temp;
	}
	
	@Bean 
	public DataSource dataSource()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/library");
		ds.setUsername("root");
		ds.setPassword("gcit");
		return ds;
	}
}
