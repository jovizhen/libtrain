package com.gcit.jms.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public abstract class BaseDao<T> implements RowMapper<T>
{
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	protected void save(String sql, Object[] vals) 
	{
		jdbcTemplate.update(sql, vals);
	}

	@SuppressWarnings("unchecked")
	protected List<T> read(String sql, Object[] vals) 
	{
		return (List<T>) jdbcTemplate.query(sql, vals, this);
	}
	
	public abstract void create(T object) throws ClassNotFoundException, SQLException;

	public abstract void delete(T object) throws ClassNotFoundException, SQLException;

	public abstract void update(T object) throws ClassNotFoundException, SQLException;

	public abstract List<T> readAll() throws ClassNotFoundException, SQLException;
	
	public abstract T read(int id) throws ClassNotFoundException, SQLException;
}
