package com.gcit.library;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcit.library.dao.AuthorDao;
import com.gcit.library.dao.BookCopyDao;
import com.gcit.library.dao.BookDao;
import com.gcit.library.dao.BookLoanDao;
import com.gcit.library.dao.BorrowerDao;
import com.gcit.library.dao.LibraryBranchDao;
import com.gcit.library.dao.PublisherDao;
import com.gcit.library.service.AdminService;

@Configuration
public class SpringConfig
{
	@Bean
	public AdminService adminService()
	{
		return new AdminService();
	}
	
	@Bean
	public AuthorDao AuthorDao()
	{
		return new AuthorDao();
	}
	
	@Bean 
	public BookDao BookDao()
	{
		return new BookDao();
	}
	
	@Bean 
	public BookCopyDao BookCopyDao()
	{
		return new BookCopyDao();
	}
	
	@Bean
	public BookLoanDao bookLoanDao()
	{
		return new BookLoanDao();
	}
	
	@Bean 
	public BorrowerDao BorrowerDao()
	{
		return new BorrowerDao();
	}
	
	@Bean
	public LibraryBranchDao branchDao()
	{
		return new LibraryBranchDao();
	}
	
	@Bean
	public PublisherDao publisherDao()
	{
		return new PublisherDao();
	}
	
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
