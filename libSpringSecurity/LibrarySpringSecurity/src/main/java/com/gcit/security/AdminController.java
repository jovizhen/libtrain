package com.gcit.security;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcit.security.entity.Author;
import com.gcit.security.entity.Book;
import com.gcit.security.entity.Borrower;
import com.gcit.security.entity.LibraryBranch;
import com.gcit.security.entity.Publisher;
import com.gcit.security.service.AdminService;


@Controller
public class AdminController
{
	@Autowired
	private AdminService adminService;
	
	//add new Entity controllers
		@RequestMapping(value = "/admin/showAddAuthor", method = RequestMethod.GET)
		public String showAddAuthor(Locale locale, Model model)
		{
			model.addAttribute("author", new Author());
			return "addAuthor";
		}

		@RequestMapping(value = "/admin/addAuthorAction", method = RequestMethod.POST)
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

		@RequestMapping(value = "/admin/showAddPublisher", method = RequestMethod.GET)
		public String showAddPublisher(Model model)
		{
			model.addAttribute("publisher", new Publisher());
			return "addPublisher";
		}
		
		@RequestMapping(value="/admin/addPublisherAction", method=RequestMethod.POST)
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
		
		@RequestMapping(value="/admin/showAddBranch", method=RequestMethod.GET)
		public String showAddBranch(Model model)
		{
			model.addAttribute("branch", new LibraryBranch());
			return "addBranch";
		}
		
		@RequestMapping(value="/admin/addBranchAction", method=RequestMethod.POST )
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
		
		@RequestMapping(value="/admin/showAddBook", method=RequestMethod.GET)
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
		
		@RequestMapping(value="/admin/addBookAction", method=RequestMethod.POST)
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
		
		@RequestMapping(value="/admin/showAddBorrower", method=RequestMethod.GET)
		public String showAddBorrower(Model model)
		{
			model.addAttribute("borrower", new Borrower());
			return "addBorrower";
		}

		@RequestMapping(value="/admin/addBorrowerAction", method= RequestMethod.POST)
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
		@RequestMapping(value = "/admin/showAuthorList", method = RequestMethod.GET)
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
		
		@RequestMapping(value="/admin/showPublisherList", method = RequestMethod.GET)
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
		
		@RequestMapping(value = "/admin/showBookList", method = RequestMethod.GET)
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
		
		@RequestMapping(value="/admin/showBranchList", method=RequestMethod.GET)
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
		
		@RequestMapping(value="/admin/showBorrowerList", method=RequestMethod.GET)
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
		@RequestMapping(value = "/admin/updateAuthorAction", method = RequestMethod.POST)
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
		
		@RequestMapping(value = "/admin/updatePublisherAction", method = RequestMethod.POST)
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

		@RequestMapping(value = "/admin/updateBranchAction", method = RequestMethod.POST)
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
		
		@RequestMapping(value = "/admin/updateBorrowerAction", method = RequestMethod.POST)
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
		
		@RequestMapping(value = "/admin/updateBookAction", method = RequestMethod.POST)
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
		@RequestMapping(value="/admin/deleteAuthorAction", method=RequestMethod.POST)
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

		@RequestMapping(value = "/admin/deletePublisherAction", method = RequestMethod.POST)
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

		@RequestMapping(value = "/admin/deleteBranchAction", method = RequestMethod.POST)
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
		
		@RequestMapping(value="/admin/deleteBorrowerAction", method=RequestMethod.POST)
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
		
		@RequestMapping( value="/admin/deleteBookAction", method=RequestMethod.POST)
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
