package com.gcit.jovi.library.dao;

import org.springframework.stereotype.Repository;

import com.gcit.jovi.library.hbm.domain.LibraryBranch;

@Repository("branchDao")
public class BranchDao extends BaseDao<LibraryBranch>
{

	@Override
	protected void setEntityClass()
	{
		this.entityClass = LibraryBranch.class;
	}
}
