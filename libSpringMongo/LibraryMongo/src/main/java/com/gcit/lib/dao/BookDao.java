package com.gcit.lib.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gcit.lib.entity.Book;
import com.mongodb.WriteResult;

public class BookDao
{
	@Autowired
	private MongoTemplate		mongoTemplate;

	private static final String	LIBRARY_COLLECTION	= "Book";

	public void create(Book p)
	{
		this.mongoTemplate.insert(p, LIBRARY_COLLECTION);
	}

	public Book readById(String id)
	{
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoTemplate.findOne(query, Book.class,
				LIBRARY_COLLECTION);
	}
	
	public List<Book> readAll()
	{
		return mongoTemplate.findAll(Book.class, LIBRARY_COLLECTION);
	}

	public void update(Book p)
	{
		this.mongoTemplate.save(p, LIBRARY_COLLECTION);
	}

	public int deleteById(String id)
	{
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoTemplate.remove(query, Book.class,
				LIBRARY_COLLECTION);
		return result.getN();
	}
	
	public List<Book> searchBook(String keyWord, String authId, String pubId, String genreId)
	{
		Query query = new Query(Criteria.where("title").regex(keyWord));
//		if(!authId.equals("NONE"))
//			query.addCriteria(Criteria.where("authors").all(o))
		return mongoTemplate.find(query, Book.class, LIBRARY_COLLECTION);
	}
}
