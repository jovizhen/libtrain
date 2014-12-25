package com.gcit.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.library.dao.AuthorDao;
import com.gcit.library.dao.BookDao;
import com.gcit.library.dao.BorrowerDao;
import com.gcit.library.dao.LibraryBranchDao;
import com.gcit.library.dao.PublisherDao;
import com.gcit.library.dao.domain.Author;
import com.gcit.library.dao.domain.Book;
import com.gcit.library.dao.domain.Borrower;
import com.gcit.library.dao.domain.LibraryBranch;
import com.gcit.library.dao.domain.Publisher;

public class AdminService 
{
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private PublisherDao publisherDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private LibraryBranchDao branchDao;
	@Autowired
	private BorrowerDao borrowerDao;
	
	// get all methods
	public List<Author> getAllAuthors()
	{
		return authorDao.readAll();
	}

	public List<Publisher> getAllPublishers()
	{
		return publisherDao.readAll();
	}

	public List<Book> getAllBooks() 
	{
		return bookDao.readAll();
	}
	
	public List<LibraryBranch> getAllBranchs()
	{
		return branchDao.readAll();
	}

	public List<Borrower> getAllBorrowers()
	{
		return borrowerDao.readAll();
	}
	
	// get by name
	public List<Author> getAuthorsByName(String name)
	{
		return authorDao.readByName(name);
	}
	
	public List<Publisher> getPublishersByName(String name)
	{
		return publisherDao.readByName(name);
	}
	
	public List<Book> getBooksByName(String name)
	{
		return bookDao.readByName(name);
	}
	
	public List<LibraryBranch> getBranchsByName(String name)
	{
		return branchDao.readByName(name);
	}
	
	public List<Borrower> getBorrowersByName(String name)
	{
		return borrowerDao.readByName(name);
	}
	
	//get by Id
	public Author getAuthor(int id)
	{
		return authorDao.read(id);
	}
	
	public Publisher getPublisher(int id)
	{
		return publisherDao.read(id);
	}
	
	public Book getBook(int id)
	{
		return bookDao.read(id);
	}

	public LibraryBranch getBranch(int id)
	{
		return branchDao.read(id);
	}
	
	public Borrower getBorrower(int id)
	{
		return borrowerDao.read(id);
	}
	
	//add new methods
	public void addAuthor(Author a) 
	{
		authorDao.create(a);
	}
	
	public void addPublisher(Publisher p)
	{
		publisherDao.create(p);
	}
	
	public void addBook(Book bk) throws Exception
	{
		bookDao.create(bk);
	}
	
	public void addLibraryBranch(LibraryBranch branch)
	{
		branchDao.create(branch);
	}

	public void addBorrower(Borrower br)
	{
		borrowerDao.create(br);
	}
	
	// update methods
	public void updateAuthor(Author a) 
	{
		authorDao.update(a);
	}
	
	public void updatePublisher(Publisher pub)
	{
		publisherDao.update(pub);
	}
	
	public void updateBook(Book book)
	{
		bookDao.update(book);
	}
	
	public void updateBranch(LibraryBranch branch)
	{
		branchDao.update(branch);
	}
	
	public void updateBorrower(Borrower borrower)
	{
		borrowerDao.update(borrower);
	}

	// Delete methods
	public void deleteAuthor(Author a) 
	{
		authorDao.delete(a);
	}

	public void deletePublisher(Publisher publisher)
	{
		publisherDao.delete(publisher);
	}
	
	public void deleteBook(Book book)
	{
		bookDao.delete(book);
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
