package com.gcit.lib.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gcit.lib.entity.Publisher;
import com.mongodb.WriteResult;

public class PublisherDao
{
	@Autowired
	MongoTemplate	mongoTemplate;

	private static final String LIBRARY_COLLECTTION = "Publisher";
	
	public void create(Publisher pub)
	{
		mongoTemplate.insert(pub, LIBRARY_COLLECTTION);
	}
	
	public Publisher readById(String id)
	{
		Query query = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(query, Publisher.class,LIBRARY_COLLECTTION);
	}
	
	public List<Publisher> readAll()
	{
		return mongoTemplate.findAll(Publisher.class, LIBRARY_COLLECTTION);
	}
	
	public void updatePublisher(Publisher pub)
	{
		mongoTemplate.save(pub, LIBRARY_COLLECTTION);
	}
	
	public int deleteById(String id)
	{
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult wr= mongoTemplate.remove(query,Publisher.class, LIBRARY_COLLECTTION);
		return wr.getN();
	}
}
