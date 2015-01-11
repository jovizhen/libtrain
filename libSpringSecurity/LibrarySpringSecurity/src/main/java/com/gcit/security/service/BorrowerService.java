package com.gcit.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.security.dao.BookCopyDao;
import com.gcit.security.dao.BookDao;
import com.gcit.security.dao.BookLoanDao;
import com.gcit.security.dao.BorrowerDao;
import com.gcit.security.dao.LibraryBranchDao;

@Service("borrowerService")
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
