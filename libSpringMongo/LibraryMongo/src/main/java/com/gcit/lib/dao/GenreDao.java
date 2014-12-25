package com.gcit.lib.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gcit.lib.entity.Genre;
import com.mongodb.WriteResult;

public class GenreDao
{
	@Autowired
	MongoTemplate	mongoTemplate;

	private static final String LIBRARY_COLLECTTION = "Genre";
	
	public void create(Genre genre)
	{
		mongoTemplate.insert(genre, LIBRARY_COLLECTTION);
	}
	
	public Genre readById(String id)
	{
		Query query = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(query, Genre.class);
	}
	
	public List<Genre> readByIds(List<String> ids)
	{
		Query query = new Query(Criteria.where("_id").in(ids));
		return mongoTemplate.find(query, Genre.class, LIBRARY_COLLECTTION);
	}
	
	public List<Genre> readAll()
	{
		return mongoTemplate.findAll(Genre.class, LIBRARY_COLLECTTION);
	}
	
	public void updateGenre(Genre genre)
	{
		mongoTemplate.save(genre);
	}
	
	public int deleteById(String id)
	{
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult wr= mongoTemplate.remove(query,Genre.class, LIBRARY_COLLECTTION);
		return wr.getN();
	}
}
