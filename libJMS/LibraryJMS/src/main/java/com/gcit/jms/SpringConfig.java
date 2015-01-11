package com.gcit.jms;

import javax.sql.DataSource;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsTemplate;

import com.gcit.jms.dao.AuthorDao;
import com.gcit.jms.dao.BookDao;
import com.gcit.jms.dao.BookLoanDao;
import com.gcit.jms.dao.LibraryBranchDao;
import com.gcit.jms.dao.PublisherDao;
import com.gcit.jms.dao.BookCopyDao;
import com.gcit.jms.dao.BorrowerDao;
import com.gcit.jms.service.AdministratorService;
import com.gcit.jms.service.messageListener.AuthorMessageListener;
import com.gcit.jms.service.messageListener.BookMessageListener;
import com.gcit.jms.service.messageListener.BorrowerMessageListener;
import com.gcit.jms.service.messageListener.BranchMessageListener;
import com.gcit.jms.service.messageListener.PublisherMessageListener;

@Configuration
public class SpringConfig
{

	@Bean(name = "jmsConnectionFactory")
	public ActiveMQConnectionFactory jmsConnectionFactory()
	{
		ActiveMQConnectionFactory connFactory = new ActiveMQConnectionFactory();
		connFactory.setBrokerURL("tcp://localhost:61616");

		return connFactory;
	}

	@Bean(name = "authorQueue")
	public ActiveMQQueue authorQueue()
	{
		ActiveMQQueue authorQueue = new ActiveMQQueue("author.queue");
		return authorQueue;
	}
	
	@Bean(name="publisherQueue")
	public ActiveMQQueue publisherQueue()
	{
		ActiveMQQueue publisherQueue=new ActiveMQQueue("publisher.queue");
		return publisherQueue;
	}
	
	@Bean(name="bookQueue")
	public ActiveMQQueue bookQueue()
	{
		ActiveMQQueue bookQueue=new ActiveMQQueue("book.queue");
		return bookQueue;
	}
	
	@Bean(name="branchQueue")
	public ActiveMQQueue branchQueue()
	{
		ActiveMQQueue branchQueue=new ActiveMQQueue("branch.queue");
		return branchQueue;
	}
	
	@Bean(name="borrowerQueue")
	public ActiveMQQueue borrowerQueue()
	{
		ActiveMQQueue borrowerQueue=new ActiveMQQueue("borrower.queue");
		return borrowerQueue;
	}
	
	@Bean(name = "jmsTemplate")
	public JmsTemplate jmsTemplate()
	{
		JmsTemplate temp = new JmsTemplate();
		temp.setConnectionFactory(jmsConnectionFactory());
		return temp;
	}
	
	@Bean(name="publisherMessageListener")
	public PublisherMessageListener PublisherMessageListener()
	{
		return new PublisherMessageListener();
	}

	@Bean(name = "authorMessageListener")
	public AuthorMessageListener authorMessageListener()
	{
		return new AuthorMessageListener();
	}
	
	@Bean(name= "bookMessageListener")
	public BookMessageListener bookMessageListener()
	{
		return new BookMessageListener();
	}
	
	@Bean(name = "branchMessageListener")
	public BranchMessageListener branchMessageListener()
	{
		return new BranchMessageListener();
	}
	
	@Bean(name = "borrowerMessageListener")
	public BorrowerMessageListener borrowerMessageListener()
	{
		return new BorrowerMessageListener();
	}
	
	@Bean
	public AdministratorService adminService()
	{
		return new AdministratorService();
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
	public JdbcTemplate template()
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
