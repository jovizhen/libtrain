package com.gcit.lib.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lib.entity.Author;
import com.gcit.lib.entity.Book;
import com.gcit.lib.entity.Genre;
import com.gcit.lib.entity.Publisher;
import com.gcit.lib.service.AdministratorService;

@RestController
public class HomeRestController {

	@Autowired
	private AdministratorService adminService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */

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
	
	@RequestMapping(value="/addPublisherAction/{name}/{address}/{phone}",  headers = "Accept=application/json")
	public String addPublisherAction(Publisher publisher)
	{
		try
		{
			adminService.addPublisher(publisher);
			return "Publisher Added Succesfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Publisher Add Failed!";
		}
	}
	
	@RequestMapping(value="/addGenreAction/{genreName}", headers = "Accept=application/json")
	public String addGenreAction(Genre genre)
	{
		try
		{
			adminService.addGenre(genre);
			return "Genre added successfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Add Genre Failed!";
		}
	}

	@RequestMapping(value = "/addBookAction/{title}/{publisher}/{authors}/{genres}", headers = "Accept=application/json")
	public String addBookAction(@PathVariable String title, 
			@PathVariable String publisher, 
			@PathVariable List<String> authors,
			@PathVariable List<String> genres)
	{
		try
		{
			Book book=new Book();
			String pubId=publisher;
			List<String> aIds=authors;
			List<String> gIds=genres;
			Publisher pub = adminService.getPubById(pubId);
			List<Author> authorList = adminService.getAuthorListByIds(aIds);
			List<Genre> genreList = adminService.getGenreListByIds(gIds);
			book.setTitle(title);
			book.setPublisher(pub);
			book.setAuthors(authorList);
			book.setGenres(genreList);
			
			adminService.addBook(book);
			return "Genre added successfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Add Genre Failed!";
		}
	}
	
	// update entity
	
	@RequestMapping(value="updateAuthorRest/{id}/{authorName}",headers = "Accept=application/json")
	public String updateAuthorRest(Author author)
	{
		try
		{
			adminService.updateAuthor(author);
			return "updated author successfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "update author fialed!";
		}
	}
	
	@RequestMapping(value="updateBookRest/{id}/{title}/{publisher}/{authors}/{genres}", headers = "Accept=application/json")
	public String updateBookRest()
	{
		return null;
	}
	
	@RequestMapping(value="updatePublisherRest/{id}/{name}/{address}/{phone}", headers = "Accept=application/json")
	public String updatePublisherRest(Publisher publisher)
	{
		try
		{
			adminService.updatePublisher(publisher);
			return "update publisher successfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "update publisher failed!";
		}
	}
	
	@RequestMapping(value="updateGenreRest/{id}/{genreName}", headers = "Accept=application/json")
	public String updateGenreRest(Genre genre)
	{
		try
		{
			adminService.updateGenre(genre);
			return "update genre successfully!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "update genre failed!";
		}
	}
	
	//delete entity
	@RequestMapping(value="deleteAuthorRest/{id}", headers = "Accept=application/json")
	public String deleteAuthorRest(@PathVariable String id)
	{
		try
		{
			adminService.deleteAuthor(id);
			return "Delete Author successuflly!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Delete Author failed!";
		}
	}
	
	@RequestMapping(value="deleteBookRest/{id}", headers = "Accept=application/json")
	public String deleteBookRest(@PathVariable String id)
	{
		try
		{
			adminService.deleteBook(id);
			return "Delete Book successuflly!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Delete Book failed!";
		}
	}
	
	@RequestMapping(value="deletePublisherRest/{id}", headers = "Accept=application/json")
	public String deletePublisherRest(@PathVariable String id)
	{
		try
		{
			adminService.deletePublisher(id);
			return "Delete Publisher successuflly!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Delete Publisher failed!";
		}
	}
	
	@RequestMapping(value="deleteGenreRest/{id}", headers = "Accept=application/json")
	public String deleteGenreRest(@PathVariable String id)
	{
		try
		{
			adminService.deleteGenre(id);
			return "Delete Genre successuflly!";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "Delete Genre failed!";
		}
	}
	
	// show list service
	@RequestMapping(value = "/showAuthorListRest",  headers = "Accept=application/json")
	public List<Author> showAuthorListRest()
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
	
	@RequestMapping(value="/showPublisherListRest", headers = "Accept=application/json")
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
	
	@RequestMapping(value="/showGenreListRest", headers="Accept=application/json")
	public List<Genre> showGenreListRest()
	{
		try
		{
			return adminService.getAllGenres();
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/showBookListRest",  headers = "Accept=application/json")
	public List<Book> showBookListRest()
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
	
	@RequestMapping (value="/seachBookAction/{keyWord}/{authorId}/{pubId}/{genreId}", headers="Accept=application/json")
	public List<Book> searchBookAction(@PathVariable String keyWord,
			@PathVariable String authorId, 
			@PathVariable String pubId,
			@PathVariable String genreId)
	{	

		return adminService.searchBook(keyWord, authorId, pubId, genreId);
	}
	
	
//	@RequestMapping (value="/seachBookAction/{keyWord}", headers="Accept=application/json")
//	public List<Book> searchBookAction(@PathVariable String keyWord)
//	{	
//
//		String kString= keyWord;
//		List<Book> books = adminService.searchBook(keyWord, "none", "none", "none");
//		return books;
//	}
}

