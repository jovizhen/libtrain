package com.gcit.jovi.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.jovi.library.dao.AuthorDao;
import com.gcit.jovi.library.dao.BookDao;
import com.gcit.jovi.library.dao.BorrowerDao;
import com.gcit.jovi.library.dao.BranchDao;
import com.gcit.jovi.library.dao.PublisherDao;
import com.gcit.jovi.library.hbm.domain.Author;
import com.gcit.jovi.library.hbm.domain.Book;
import com.gcit.jovi.library.hbm.domain.Borrower;
import com.gcit.jovi.library.hbm.domain.LibraryBranch;
import com.gcit.jovi.library.hbm.domain.Publisher;

@Service("adminService")
public class AdminService
{
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private PublisherDao publisherDao;
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private BorrowerDao borrowerDao;

	//Create
	public void saveBook(Book book)
	{
		bookDao.save(book);
	}
	
	public void saveAuthor(Author author)
	{
		authorDao.save(author);
	}
	
	public void savePublisher(Publisher publisher)
	{
		publisherDao.save(publisher);
	}
	
	public void saveBranch(LibraryBranch branch)
	{
		branchDao.save(branch);
	}

	public void saveBorrower(Borrower borrower)
	{
		borrowerDao.save(borrower);
	}
	
	//Read by id
	public Book getBook(Integer id)
	{
		return bookDao.read(id);
	}
	
	public Author getAuthor(Integer id)
	{
		return authorDao.read(id);
	}
	
	public Publisher getPublisher(Integer id)
	{
		return publisherDao.read(id);
	}
	
	public LibraryBranch getBranch(Integer id)
	{
		return branchDao.read(id);
	}
	
	public Borrower getBorrower(Integer id)
	{
		return borrowerDao.read(id);
	}
	
	//Read All
	public List<Book> getAllBooks()
	{
		return bookDao.readAll();
	}
	
	public List<Author> getAllAuthors()
	{
		return authorDao.readAll();
	}
	
	public List<Publisher> getAllPublishers()
	{
		return publisherDao.readAll();
	}
	
	public List<LibraryBranch> getAllBranchs()
	{
		return branchDao.readAll();
	}
	
	public List<Borrower> getAllBorrowers()
	{
		return borrowerDao.readAll();
	}
	
	//Update
	public void updateBook(Book book)
	{
		bookDao.update(book);
	}
	
	public void updateAuthor(Author author)
	{
		authorDao.update(author);
	}
	
	public void updatePublisher(Publisher pub)
	{
		publisherDao.update(pub);
	}
	
	public void updateBranch(LibraryBranch branch)
	{
		branchDao.update(branch);
	}
	
	public void updateBorrower(Borrower borrower)
	{
		borrowerDao.update(borrower);
	}
	
	//Delete
	public void deleteBook(Book book)
	{
		bookDao.delete(book);
	}
	
	public void deleteAuthor(Author author)
	{
		authorDao.delete(author);
	}
	
	public void deletePublisher(Publisher pub)
	{
		publisherDao.delete(pub);
	}
	
	public void deleteBranch(LibraryBranch branch)
	{
		branchDao.delete(branch);
	}
	
	public void deleteBorrower(Borrower borrower)
	{
		borrowerDao.delete(borrower);
	}
}
