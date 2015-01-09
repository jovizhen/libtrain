package com.gcit.jovi.library;

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

import com.gcit.jovi.library.hbm.domain.Author;
import com.gcit.jovi.library.hbm.domain.Book;
import com.gcit.jovi.library.hbm.domain.Borrower;
import com.gcit.jovi.library.hbm.domain.LibraryBranch;
import com.gcit.jovi.library.hbm.domain.Publisher;
import com.gcit.jovi.library.service.AdminService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value="/showSearchBook", method=RequestMethod.GET)
	public String showSearchBook(Model model)
	{
		model.addAttribute("authors", adminService.getAllAuthors());
		model.addAttribute("publishers", adminService.getAllPublishers());
		return "bookSearch";
	}
	
	@RequestMapping(value="/searchBookAction", method=RequestMethod.POST)
	public String searchBookAction(Model model)
	{
		model.addAttribute("authors", adminService.getAllAuthors());
		model.addAttribute("publishers", adminService.getAllPublishers());
		return "bookSearch";
	}
	
	//add new Entity controllers
	@RequestMapping(value="/showAddBook", method=RequestMethod.GET)
	public String showAddBook(Model model)
	{
		model.addAttribute("authorList", adminService.getAllAuthors());
		model.addAttribute("publisherList", adminService.getAllPublishers());
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	@RequestMapping(value="/addBookAction", method=RequestMethod.POST)
	public String addBookAction(@ModelAttribute Book book, Model model)
	{
		try
		{
			adminService.saveBook(book);
			model.addAttribute("result", "Add Book Successfully!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("result", "Add Book Failed! "+e.getMessage());
		}
		return "index";
	}
	
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
			adminService.saveAuthor(author);
			model.addAttribute("result", "Author Added Succesfully!");
		} catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("result", "Author Add Failed: " + e.getMessage());
		}
		return "index";
	}
	
	@RequestMapping(value="/showAddPublisher", method= RequestMethod.GET)
	public String showAddPublisher(Model model)
	{
		Publisher publisher = new Publisher();
		model.addAttribute("publisher", publisher);
		return "addPubLisher";
	}
	
	@RequestMapping(value="/addPublisherAction", method=RequestMethod.POST)
	public String addPublisherAction(@ModelAttribute Publisher publisher, Model model)
	{
		try
		{
			adminService.savePublisher(publisher);
			model.addAttribute("result", "Publisher Added successfully!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("result", "Publisher Add Failed!"+e.getMessage());
		}
		return "index";
	}
	
	@RequestMapping(value="/showAddBranch", method=RequestMethod.GET)
	public String showAddBranch(Model model)
	{
		LibraryBranch branch = new LibraryBranch();
		model.addAttribute("branch", branch);
		return "addBranch";
	}
	
	@RequestMapping(value="/addBranchAction", method=RequestMethod.POST)
	public String addBranchAction(@ModelAttribute LibraryBranch branch, Model model)
	{
		try
		{
			adminService.saveBranch(branch);
			model.addAttribute("result", "Add Branch successfully!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("result", "Add Branch Failed!");
		}
		return "index";
	}

	@RequestMapping(value = "/showAddBorrower", method = RequestMethod.GET)
	public String showAddBorrower(Model model)
	{
		Borrower borrower = new Borrower();
		model.addAttribute("borrower", borrower);
		return "addBorrower";
	}

	@RequestMapping(value = "/addBorrowerAction", method = RequestMethod.POST)
	public String addBorrowerAction(@ModelAttribute Borrower borrower,
			Model model)
	{
		try
		{
			adminService.saveBorrower(borrower);
			model.addAttribute("result", "Borrower Added Successfully!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("result",
					"Borrower Added Failed! " + e.getMessage());
		}
		return "index";
	}
	
	//show List
	@RequestMapping(value = "/showBookList", method = RequestMethod.GET)
	public String showBookList(Model model)
	{
		try
		{
			model.addAttribute("bookList", adminService.getAllBooks());
			model.addAttribute("authorList", adminService.getAllAuthors());
			model.addAttribute("pubLisherList", adminService.getAllPublishers());
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		return "showBookList";
	}
	
	
	@RequestMapping(value="/showBorrowerList", method=RequestMethod.GET)
	public String showBorrowerList(Model model)
	{
		try
		{
			model.addAttribute("borrowerList", adminService.getAllBorrowers());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "showBorrowerList";
	}
	
	@RequestMapping(value = "/showAuthorList", method = RequestMethod.GET)
	public String showAuthorsList(Locale locale, Model model)
	{
		try
		{
			model.addAttribute("authorList", adminService.getAllAuthors());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return "showAuthorList";
	}
	
	@RequestMapping(value="/showPublisherList", method=RequestMethod.GET)
	public String showPublisherList(Model model)
	{
		try
		{
			model.addAttribute("publisherList", adminService.getAllPublishers());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "showPublisherList";
	}

	
	@RequestMapping(value="showBranchList", method=RequestMethod.GET)
	public String showBranchList(Model model)
	{
		try
		{
			model.addAttribute("branchList", adminService.getAllBranchs());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "showBranchList";
	}
	
	//update entity
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
			@RequestParam(value = "publisherPhone") String publisherPhone)
	{
		try
		{
			Publisher publisher = new Publisher(publisherId, publisherName, 
					publisherAddress, publisherPhone);
			adminService.updatePublisher(publisher);
			return "publisher updated successfully!";

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "publisher update Failed!"+e.getMessage();
		}
	}

	@RequestMapping(value = "updateBranchAction", method = RequestMethod.POST)
	public @ResponseBody String updateBranchAction(
			@RequestParam(value = "branchId") int branchId,
			@RequestParam(value = "branchName") String branchName,
			@RequestParam(value = "branchAddress") String branchAddress)
	{
		try
		{
			LibraryBranch branch = new LibraryBranch(branchId, branchName,
					branchAddress);
			adminService.updateBranch(branch);
			return "Update branch successfully!";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "update branch Failed! " + e.getMessage();
			// TODO: handle exception
		}
	}

	@RequestMapping(value = "/updateBorrowerAction", method = RequestMethod.POST)
	public @ResponseBody String updateBorrowerAction(
			@RequestParam(value = "cardNo") int cardNo,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "cardNo") String phone)
	{
		try
		{
			Borrower borrower = new Borrower(cardNo, name, address, phone);
			adminService.updateBorrower(borrower);
			return "Update borrower successfully!";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "update borrower Failed! " + e.getMessage();
		}
	}

	@RequestMapping(value = "/updateBookAction", method = RequestMethod.POST)
	public @ResponseBody String updateBookAction(
			@RequestParam(value = "bookId") int bookId,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "authorId") int authorId,
			@RequestParam(value = "publisherId") int publisherId)
	{
		try
		{
			Author author = new Author();
			author.setAuthorId(authorId);
			Publisher publisher = new Publisher();
			publisher.setPublisherId(publisherId);
			Book book = new Book(bookId, author, publisher, title);
			adminService.updateBook(book);
			return "Update book successfully!";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "update book Failed! " + e.getMessage();
		}
	}

	// delete entity
	@RequestMapping(value = "/deleteAuthorAction", method = RequestMethod.POST)
	public @ResponseBody String deleteAuthorAction(
			@RequestParam(value = "authorId") int authorId, Model model)
	{
		Author author = new Author();
		author.setAuthorId(authorId);
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
			@RequestParam(value = "publisherId") int publisherId)
	{
		try
		{
			Publisher publisher=new Publisher();
			publisher.setPublisherId(publisherId);
			adminService.deletePublisher(publisher);
			return "Delete Publisher Successfully!";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Delete Publisher Failed! "+e.getMessage();
		}
	}

	@RequestMapping(value="/deleteBranchAction", method=RequestMethod.POST)
	public @ResponseBody String deleteBranchAction(@RequestParam (value="branchId") int branchId)
	{
		try
		{
			LibraryBranch branch = new LibraryBranch();
			branch.setBranchId(branchId);
			adminService.deleteBranch(branch);
			return "Delete Branch successfully!";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Delete Branch Failed! "+e.getMessage();
		}
	}
	
	@RequestMapping(value="/deleteBorrowerAction", method=RequestMethod.POST)
	public @ResponseBody String deleteBorrowerAction(@RequestParam (value="cardNo") int cardNo)
	{
		try
		{
			Borrower borrower = new Borrower();
			borrower.setCardNo(cardNo);
			adminService.deleteBorrower(borrower);
			return "Delete Borrower successfully!";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Delete Borrower Failed! "+e.getMessage();
		}
	}
	
	@RequestMapping(value="/deleteBookAction", method=RequestMethod.POST)
	public @ResponseBody String deleteBookAction(@RequestParam (value="bookId") int bookId)
	{
		try
		{
			Book book =new Book();
			book.setBookId(bookId);
			adminService.deleteBook(book);
			return "Delete Book successfully!";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Delete Book Failed! "+e.getMessage();
		}
	}
}
