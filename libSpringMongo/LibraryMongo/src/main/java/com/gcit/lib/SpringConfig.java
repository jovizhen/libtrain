package com.gcit.lib;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.gcit.lib.dao.AuthorDao;
import com.gcit.lib.dao.BookDao;
import com.gcit.lib.dao.GenreDao;
import com.gcit.lib.dao.PublisherDao;
import com.gcit.lib.service.AdministratorService;
import com.mongodb.MongoClient;

@Configuration
public class SpringConfig
{
	@Bean
	public AdministratorService AdministratorService()
	{
		return new AdministratorService();
	}
	
	@Bean
	public AuthorDao authDao()
	{
		return new AuthorDao();
	}

	@Bean
	public BookDao bookDao()
	{
		return new BookDao();
	}
	
	@Bean
	public PublisherDao pubDao()
	{
		return new PublisherDao();
	}
	
	@Bean
	public GenreDao genreDao()
	{
		return new GenreDao();
	}

	public @Bean MongoDbFactory getMongoDbFactory() throws Exception
	{
		return new SimpleMongoDbFactory(
				new MongoClient("localhost", 27017), "Library");
	}

	public @Bean MongoTemplate getMongoTemplate() throws Exception
	{
		MongoTemplate mongoTemplate = new MongoTemplate(
				getMongoDbFactory());
		return mongoTemplate;
	}
}
