package com.gcit.library.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.library.dao.BookCopyDao;
import com.gcit.library.dao.BookDao;
import com.gcit.library.dao.BookLoanDao;
import com.gcit.library.dao.BorrowerDao;
import com.gcit.library.dao.LibraryBranchDao;

public class BorrowerService 
{
	@Autowired
	private BookLoanDao bookLoanDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookCopyDao bookCopyDao;
	
	@Autowired
	private LibraryBranchDao branchDao;
	
	@Autowired
	private BorrowerDao borrowerDao;
}
