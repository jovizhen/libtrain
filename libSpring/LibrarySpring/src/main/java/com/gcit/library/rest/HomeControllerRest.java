package com.gcit.library.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.library.dao.domain.Author;
import com.gcit.library.dao.domain.Book;
import com.gcit.library.dao.domain.Borrower;
import com.gcit.library.dao.domain.LibraryBranch;
import com.gcit.library.dao.domain.Publisher;
import com.gcit.library.service.AdminService;

@RestController
public class HomeControllerRest
{
	@Autowired
	private AdminService		adminService;
//add entity
	@RequestMapping(value = "/addAuthorAction/{authorName}", headers = "Accept=application/json")
	public String addAuthorAction(Author author)
	{
		try
		{
			adminService.addAuthor(author);
			return "Author Added Succesfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Author Add Failed!";
		}
	}
	
	@RequestMapping(value="addPublisherAction/{publisherName}/{publisherAddress}/{publisherPhone}", headers = "Accept=application/json")
	public Publisher addPublisherAction(Publisher publisher)
	{
		try
		{
			adminService.addPublisher(publisher);
			return publisher;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="addBranchAction/{branchName}/{branchAddress}", headers = "Accept=application/json")
	public LibraryBranch addBranchAction(LibraryBranch branch)
	{
		try
		{
			adminService.addLibraryBranch(branch);
			return branch;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="addBorrowerAction/{name}/{address}/{phone}", headers = "Accept=application/json")
	public Borrower addBorrowerAction(Borrower borrower)
	{
		try
		{
			adminService.addBorrower(borrower);
			return borrower;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	//update entity
	
	@RequestMapping(value="/updateAuthorRest/{authorId}/{authorName}", headers = "Accept=application/json")
	public Author updateAuthorRest(Author author)
	{
		try
		{
			adminService.updateAuthor(author);
			return author;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/updatePublisherRest/{publisherId}/{publisherName}/{publisherAddress}/{publisherPhone}", headers = "Accept=application/json")
	public Publisher updatePublisherRest(Publisher publisher)
	{
		try
		{
			adminService.updatePublisher(publisher);
			return publisher;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/updateBranchRest/{branchId}/{branchName}/{branchAddress}", headers = "Accept=application/json")
	public LibraryBranch updateBranchRest(LibraryBranch branch)
	{
		try
		{
			adminService.updateBranch(branch);
			return branch;
		} catch (Exception e)
		{
			e.printStackTrace();
			return branch;
		}
	}
	
	@RequestMapping(value="/updateBorrowerRest/{cardNo}/{name}/{address}/{phone}", headers = "Accept=application/json")
	public Borrower updateBorrowerRest(Borrower borrower)
	{
		try
		{
			adminService.updateBorrower(borrower);
			return borrower;
		} catch (Exception e)
		{
			e.printStackTrace();
			return borrower;
		}
	}
	
	//Delete Entity
	@RequestMapping(value="/deleteAuthorRest/{authorId}", headers = "Accept=application/json")
	public Author deleteAuthorRest(Author author)
	{
		try
		{
			adminService.deleteAuthor(author);
			return author;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/deletePublisherRest/{publisherId}", headers = "Accept=application/json")
	public Publisher deletePublisherRest(Publisher publisher)
	{
		try
		{
			adminService.deletePublisher(publisher);
			return publisher;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/deleteBookRest/{bookId}", headers = "Accept=application/json")
	public Book deleteBookRest(Book book)
	{
		try
		{
			adminService.deleteBook(book);
			return book;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/deleteBranchRest/{branchId}", headers = "Accept=application/json")
	public LibraryBranch deleteBranchRest(LibraryBranch branch)
	{
		try
		{
			adminService.deleteBranch(branch);
			return branch;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value="/deleteBorrowerRest/{cardNo}", headers = "Accept=application/json")
	public Borrower deleteBorrowerRest(Borrower borrower)
	{
		try
		{
			adminService.deleteBorrower(borrower);
			return borrower;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
//show List
	@RequestMapping(value = "/showAuthorListRest", headers = "Accept=application/json")
	public List<Author> showAuthorsList()
	{
		try
		{
			return adminService.getAllAuthors();
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/showBookListRest", headers = "Accept=application/json")
	public List<Book> showBookList()
	{
		try
		{
			return adminService.getAllBooks();
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/showPublisherListRest", headers="Accept=application/json")
	public List<Publisher> showPublisherListRest()
	{
		try
		{
			return adminService.getAllPublishers();
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/showBranchListRest", headers="Accept=application/json")
	public List<LibraryBranch> showBranchListRest()
	{
		try
		{
			return adminService.getAllBranchs();
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/showBorrowerListRest", headers="Accept=application/json")
	public List<Borrower> showBorrowerListRest()
	{
		try
		{
			return adminService.getAllBorrowers();
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
