package com.gcit.lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.lib.dao.AuthorDao;
import com.gcit.lib.dao.BookDao;
import com.gcit.lib.dao.GenreDao;
import com.gcit.lib.dao.PublisherDao;
import com.gcit.lib.entity.Author;
import com.gcit.lib.entity.Book;
import com.gcit.lib.entity.Genre;
import com.gcit.lib.entity.Publisher;

public class AdministratorService
{

	@Autowired
	private AuthorDao		aDao;

	@Autowired
	private BookDao			bDao;

	@Autowired
	private PublisherDao	pDao;

	@Autowired
	private GenreDao		gDao;

	// Add new entity
	public void addAuthor(Author a) throws Exception
	{
		try
		{
			aDao.create(a);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void addBook(Book a) throws Exception
	{
		try
		{
			bDao.create(a);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void addPublisher(Publisher pub) throws Exception
	{
		try
		{
			pDao.create(pub);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void addGenre(Genre genre)
	{
		try
		{
			gDao.create(genre);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// update entity
	public void updateAuthor(Author author)
	{
		try
		{
			aDao.update(author);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updateBook(Book book)
	{
		try
		{
			bDao.update(book);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updatePublisher(Publisher publisher)
	{
		try
		{
			pDao.updatePublisher(publisher);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updateGenre(Genre genre)
	{
		try
		{
			gDao.updateGenre(genre);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// Delete Entity
	public void deleteAuthor(String id)
	{
		try
		{
			aDao.deleteById(id);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deleteBook(String id)
	{
		try
		{
			bDao.deleteById(id);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deletePublisher(String id)
	{
		try
		{
			pDao.deleteById(id);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteGenre(String id)
	{
		try
		{
			gDao.deleteById(id);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// get List
	public List<Author> getAllAuthors()
	{
		return aDao.readAll();
	}

	public List<Book> getAllBooks()
	{
		return bDao.readAll();
	}

	public List<Publisher> getAllPublishers()
	{
		return pDao.readAll();
	}

	public List<Genre> getAllGenres()
	{
		return gDao.readAll();
	}

	public Publisher getPubById(String id)
	{
		return pDao.readById(id);
	}

	public List<Author> getAuthorListByIds(List<String> ids)
	{
		return aDao.readByIds(ids);
	}

	public List<Genre> getGenreListByIds(List<String> ids)
	{
		return gDao.readByIds(ids);
	}

	public List<Book> searchBook(String keyWord, String authorId,
			String pubId, String genreId)
	{
		return bDao.searchBook(keyWord, authorId, pubId, genreId);
	}
}
