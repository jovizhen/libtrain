package com.gcit.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.library.dao.BookCopyDao;
import com.gcit.library.dao.BookDao;
import com.gcit.library.dao.LibraryBranchDao;
import com.gcit.library.dao.domain.Book;
import com.gcit.library.dao.domain.BookCopy;
import com.gcit.library.dao.domain.LibraryBranch;

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
