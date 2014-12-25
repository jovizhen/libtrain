package com.gcit.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcit.library.dao.domain.Author;

public class AuthorDao extends BaseDao<Author>
{
	public AuthorDao()
	{
		
	}
	
	@Override
	public void create(Author author) 
	{
		save("insert into tbl_author (authorName) values (?)", new Object[]
		{ author.getAuthorName() });
	}

	@Override
	public void delete(Author author) 
	{
		save("delete from tbl_author where authorId = (?)", new Object[]
		{ author.getAuthorId() });
	}

	@Override
	public void update(Author author) 
	{
		save("update tbl_author set authorName = (?) where authorId = (?)",	new Object[]{author.getAuthorName(), author.getAuthorId()});
	}

	@Override
	public List<Author> readAll() 
	{
		return read("select * from tbl_author", null);
	}

	public Author read(int id) 
	{
		List<Author> result = read("select * from tbl_author where authorId = ?", new Object[]
		{ id });
		if (result != null && result.size() != 0)
		{
			return result.get(0);
		}
		return null;
	}
	
	public List<Author> readByName(String name) 
	{
		return read("select * from tbl_author where authorName like %?%", new Object[]
		{ name });
	}

	@Override
	public Author mapRow(ResultSet resultSet, int index) throws SQLException
	{
		Author author = new Author();
		author.setAuthorId(resultSet.getInt("authorId"));
		author.setAuthorName(resultSet.getString("authorName"));
		return author;
	}
}
