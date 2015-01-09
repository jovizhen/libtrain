package com.gcit.jovi.library.dao;

import org.springframework.stereotype.Repository;

import com.gcit.jovi.library.hbm.domain.Book;

@Repository("bookDao")
public class BookDao extends BaseDao<Book>
{
	@Override
	protected void setEntityClass()
	{
		this.entityClass = Book.class;
	}
}
