package com.gcit.library;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcit.library.dao.domain.Author;
import com.gcit.library.dao.domain.Book;
import com.gcit.library.dao.domain.Borrower;
import com.gcit.library.dao.domain.LibraryBranch;
import com.gcit.library.dao.domain.Publisher;
import com.gcit.library.service.AdminService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
{

	private static final Logger	logger	= LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private AdminService adminService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model)
	{
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	//add new Entity controllers
	@RequestMapping(value = "/showAddAuthor", method = RequestMethod.GET)
	public String showAddAuthor(Locale locale, Model model)
	{
		model.addAttribute("author", new Author());
		return "addAuthor";
	}

	@RequestMapping(value = "/addAuthorAction", method = RequestMethod.POST)
	public String addAuthorAction(@ModelAttribute Author author, Locale locale,
			Model model)
	{
		try
		{
			adminService.addAuthor(author);
			model.addAttribute("result", "Author Added Succesfully!");
		} catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("result", "Author Add Failed: " + e.getMessage());
		}
		return "index";
	}

	@RequestMapping(value = "/showAddPublisher", method = RequestMethod.GET)
	public String showAddPublisher(Model model)
	{
		model.addAttribute("publisher", new Publisher());
		return "addPublisher";
	}
	
	@RequestMapping(value="/addPublisherAction", method=RequestMethod.POST)
	public String addPublisherAction(@ModelAttribute Publisher publisher, Model model)
	{
		try
		{
			adminService.addPublisher(publisher);;
			model.addAttribute("result", "Publisher Added Succesfully!");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("result", "Publisher add failed");
		}
		return "index";
	}
	
	@RequestMapping(value="showAddBranch", method=RequestMethod.GET)
	public String showAddBranch(Model model)
	{
		model.addAttribute("branch", new LibraryBranch());
		return "addBranch";
	}
	
	@RequestMapping(value="addBranchAction", method=RequestMethod.POST )
	public String addBranch(@ModelAttribute LibraryBranch branch, Model model)
	{
		try
		{
			adminService.addLibraryBranch(branch);
			model.addAttribute("result", "Add Branch Succesfully!");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("result", "add branch failed!");
		}
		return "index";
	}
	
	@RequestMapping(value="showAddBook", method=RequestMethod.GET)
	public String showAddBook(Model model)
	{
		try
		{
			model.addAttribute("book", new Book());
			model.addAttribute("authorList", adminService.getAllAuthors());
			model.addAttribute("publisherList", adminService.getAllPublishers());
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "addBook";
	}
	
	@RequestMapping(value="addBookAction", method=RequestMethod.POST)
	public String addBookAction(@ModelAttribute Book book, Model model)
	{
		try
		{
			adminService.addBook(book);;
			model.addAttribute("result", "Add Book Successfully!");
		} catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("result", "Add Book Failed!");
		}
		return "index";
	}
	
	@RequestMapping(value="showAddBorrower", method=RequestMethod.GET)
	public String showAddBorrower(Model model)
	{
		model.addAttribute("borrower", new Borrower());
		return "addBorrower";
	}

	@RequestMapping(value="addBorrowerAction", method= RequestMethod.POST)
	public String addBorrowerAction(@ModelAttribute Borrower borrower, Model model)
	{
		try
		{
			adminService.addBorrower(borrower);
			model.addAttribute("result", "Add Borrower Successfully!");
		} catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("result", "Add Borrower Failed!");
		}
		return "index";
	}

	//show Lists
	@RequestMapping(value = "/showAuthorList", method = RequestMethod.GET)
	public String  showAuthorsList(Locale locale, Model model)
	{
		try
		{
			model.addAttribute("authorList", adminService.getAllAuthors());
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return "showAuthorList";
	}
	
	@RequestMapping(value="/showPublisherList", method = RequestMethod.GET)
	public String showPublisherList(Model model)
	{
		try
		{
			model.addAttribute("publisherList", adminService.getAllPublishers());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return "showPublisherList";
	}
	
	@RequestMapping(value = "/showBookList", method = RequestMethod.GET)
	public String showBookList(Model model)
	{
		try
		{
			model.addAttribute("book", new Book());
			model.addAttribute("bookList", adminService.getAllBooks());
			model.addAttribute("authorList", adminService.getAllAuthors());
			model.addAttribute("publisherList", adminService.getAllPublishers());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return "showBookList";
	}
	
	@RequestMapping(value="/showBranchList", method=RequestMethod.GET)
	public String showBranchList(Model model)
	{
		try
		{
			model.addAttribute("branchList", adminService.getAllBranchs());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return "showBranchList";
	}
	
	@RequestMapping(value="showBorrowerList", method=RequestMethod.GET)
	public String showBorrowerList(Model model)
	{
		try
		{
			model.addAttribute("borrowerList", adminService.getAllBorrowers());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return "showBorrowerList";
	}
	
	// update controllers
	@RequestMapping(value = "/updateAuthorAction", method = RequestMethod.POST)
	public @ResponseBody String updateAuthorAction(
			@RequestParam(value = "authorId") int authorId,
			@RequestParam(value = "authorName") String authorName,
			Locale locale, Model model)
	{
		try
		{
			Author author = new Author();
			author.setAuthorId(authorId);
			author.setAuthorName(authorName);
			adminService.updateAuthor(author);

			return "Author Updated Succesfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Author Update Failed!";
		}
	}
	
	@RequestMapping(value = "/updatePublisherAction", method = RequestMethod.POST)
	public @ResponseBody String updatePublisherAction(
			@RequestParam(value = "publisherId") int publisherId,
			@RequestParam(value = "publisherName") String publisherName,
			@RequestParam(value = "publisherAddress") String publisherAddress,
			@RequestParam(value = "publisherPhone") String publisherPhone,
			Model model)
	{
		try
		{
			Publisher publisher=new Publisher();
			publisher.setPublisherId(publisherId);
			publisher.setPublisherName(publisherName);
			publisher.setPublisherAddress(publisherAddress);
			publisher.setPublisherPhone(publisherPhone);
			adminService.updatePublisher(publisher);
			return "Update Publisher successfully!";
		} catch (Exception e)
		{
			return "Update Publisher Failed!";
		}
	}

	@RequestMapping(value = "/updateBranchAction", method = RequestMethod.POST)
	public @ResponseBody String updateBranchAction(
			@RequestParam(value = "branchId") int branchId,
			@RequestParam(value = "branchName") String branchName,
			@RequestParam(value = "branchAddress") String branchAddress,
			Model model)
	{
		try
		{
			LibraryBranch branch = new LibraryBranch(branchId, branchName,
					branchAddress);
			adminService.updateBranch(branch);
			return "Update branch successfully!";

		} catch (Exception e)
		{
			e.printStackTrace();
			return "Update branch Failed!";
		}
	}
	
	@RequestMapping(value = "/updateBorrowerAction", method = RequestMethod.POST)
	public @ResponseBody String updateBorrowerAction(
			@RequestParam(value = "cardNo") int cardNo,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "phone") String phone, Model model)
	{
		try
		{
			Borrower borrower = new Borrower(cardNo, name, address, phone);
			adminService.updateBorrower(borrower);
			return "Update Borrower Successfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Update Borrower Failed!";
		}
	}
	
	@RequestMapping(value = "/updateBookAction", method = RequestMethod.POST)
	public @ResponseBody String updateBookAction(
			@RequestParam(value = "bookId") int bookId,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "authorId") int authorId,
			@RequestParam(value = "publisherId") int publisherId,
			Model model)
	{
		try
		{
			Book book = new Book(bookId, title, new Author(authorId), new Publisher(publisherId));
			adminService.updateBook(book);
			return "Update Book Successfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Update Book Failed!";
		}
	}
	
	
	//Delete controllers
	@RequestMapping(value="/deleteAuthorAction", method=RequestMethod.POST)
	public @ResponseBody String deleteAuthorAction(
			@RequestParam(value = "authorId") int authorId, Model model)
	{
		Author author = new Author(authorId);
		try
		{
			adminService.deleteAuthor(author);
			return "Author Deleted Succesfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Author Deleted Failed!";
		}
	}

	@RequestMapping(value = "/deletePublisherAction", method = RequestMethod.POST)
	public @ResponseBody String deletePublisherAction(
			@RequestParam(value = "publisherId") int publisherId,
			Model model)
	{
		try
		{
			Publisher publisher = new Publisher(publisherId);
			adminService.deletePublisher(publisher);
			return "Publisher deleted successfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "publisher delete Failed!";
		}
	}

	@RequestMapping(value = "/deleteBranchAction", method = RequestMethod.POST)
	public @ResponseBody String deleteBranchAction(
			@RequestParam(value = "branchId") int branchId, Model model)
	{
		try
		{
			LibraryBranch branch = new LibraryBranch(branchId);
			adminService.deleteBranch(branch);
			return "Delete Branch Successfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Delete Branch Failed!";
		}
	}
	
	@RequestMapping(value="/deleteBorrowerAction", method=RequestMethod.POST)
	public @ResponseBody String  deleteBorrowerAction(@RequestParam(value="cardNo")int cardNo, Model model)
	{
		try
		{
			adminService.deleteBorrower(new Borrower(cardNo));
			return "Delete Borrower successfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Delete Borrower Failed!";
		}
	}
	
	@RequestMapping( value="/deleteBookAction", method=RequestMethod.POST)
	public @ResponseBody String deleteBookAction(@RequestParam(value="bookId") int bookId, Model model)
	{
		try
		{
			adminService.deleteBook(new Book(bookId));
			return "Delete book Successfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Delete book Failed!";
		}
	}
}
