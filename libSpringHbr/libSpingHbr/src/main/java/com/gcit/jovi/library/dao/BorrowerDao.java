package com.gcit.jovi.library.dao;

import org.springframework.stereotype.Repository;

import com.gcit.jovi.library.hbm.domain.Borrower;

@Repository("borrowerDao")
public class BorrowerDao extends BaseDao<Borrower>
{

	@Override
	protected void setEntityClass()
	{
		this.entityClass = Borrower.class;
	}
}
