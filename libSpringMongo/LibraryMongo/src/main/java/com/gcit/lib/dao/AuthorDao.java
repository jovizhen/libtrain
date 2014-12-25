package com.gcit.lib.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gcit.lib.entity.Author;
import com.mongodb.WriteResult;

public class AuthorDao
{
	@Autowired
	private MongoTemplate		mongoTemplate;

	private static final String	LIBRARY_COLLECTION	= "Author";

	public void create(Author p)
	{
		this.mongoTemplate.insert(p, LIBRARY_COLLECTION);
	}

	public Author readById(String id)
	{
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoTemplate.findOne(query, Author.class,
				LIBRARY_COLLECTION);
	}
	
	public List<Author> readByIds(List<String> ids)
	{
		Query query = new Query(Criteria.where("_id").in(ids));
		return mongoTemplate.find(query, Author.class, LIBRARY_COLLECTION);
	}
	
	public List<Author> readAll()
	{
		return mongoTemplate.findAll(Author.class, LIBRARY_COLLECTION);
	}

	public void update(Author p)
	{
		this.mongoTemplate.save(p, LIBRARY_COLLECTION);
	}

	public int deleteById(String id)
	{
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoTemplate.remove(query,
				Author.class, LIBRARY_COLLECTION);
		return result.getN();
	}
}
