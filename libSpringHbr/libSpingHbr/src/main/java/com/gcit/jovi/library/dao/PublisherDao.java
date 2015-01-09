package com.gcit.jovi.library.dao;

import org.springframework.stereotype.Repository;

import com.gcit.jovi.library.hbm.domain.Publisher;

@Repository("publisherDao")
public class PublisherDao extends BaseDao<Publisher>
{
	@Override
	protected void setEntityClass()
	{
		this.entityClass = Publisher.class;
	}
}
