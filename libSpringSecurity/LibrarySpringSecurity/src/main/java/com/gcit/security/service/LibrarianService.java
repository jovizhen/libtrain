package com.gcit.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.security.dao.BookCopyDao;
import com.gcit.security.dao.BookDao;
import com.gcit.security.dao.LibraryBranchDao;
import com.gcit.security.entity.Book;
import com.gcit.security.entity.BookCopy;
import com.gcit.security.entity.LibraryBranch;

@Service("libService")
public class LibrarianService 
{
	@Autowired
	private LibraryBranchDao branchDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookCopyDao bookCopyDao;
	
	//get all methods
	public List<LibraryBranch> getAllBranchs()
	{
		return branchDao.readAll();
	}
	
	public List<Book> getAllBooks()
	{
		return bookDao.readAll();
	}
	
	public List<BookCopy> getAllBookCopies()
	{
		return bookCopyDao.readAll();
	}
	
	//get by Id
	
	//get by name
	
}
