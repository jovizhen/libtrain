package com.gcit.jovi.library.dao;


import org.springframework.stereotype.Repository;

import com.gcit.jovi.library.hbm.domain.Author;

@Repository("authorDao")
public class AuthorDao extends BaseDao<Author>
{
	@Override
	protected void setEntityClass()
	{
		this.entityClass = Author.class;
	}
	
}
