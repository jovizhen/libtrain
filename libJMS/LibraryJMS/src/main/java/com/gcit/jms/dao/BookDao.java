package com.gcit.jms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.jms.entity.Book;



public class BookDao extends BaseDao<Book>
{

	@Autowired
	AuthorDao authorDao;
	
	@Autowired
	PublisherDao PublisherDao;
	
	@Override
	public void create(Book book) 
	{
		save("insert into tbl_book (title, authId, pubId) values (?,?,?)",
				new Object[]
				{
						book.getTitle(),
						(book.getAuthor() != null) ? book.getAuthor()
								.getAuthorId() : null,
						book.getPublisher() != null ? book.getPublisher()
								.getPublisherId() : null });
	}

	@Override
	public void delete(Book book)
	{
		save("delete from tbl_book where bookId = (?)", new Object[]
		{ book.getBookId() });
	}

	@Override
	public void update(Book book)
	{
		save("update tbl_book set title = ?, authId = ?, pubId = ? where bookId = ?",
				new Object[]
				{
						book.getTitle(),
						(book.getAuthor() != null) ? book.getAuthor()
								.getAuthorId() : null,
						book.getPublisher() != null ? book.getPublisher()
								.getPublisherId() : null, book.getBookId() });
	}

	@Override
	public List<Book> readAll()
	{
		return read("select * from tbl_book", null);
	}
	
	public Book read(int id)
	{
		List<Book> result = read(
				"select * from tbl_book where bookId = ?", new Object[] { id });

		if (result != null && result.size() != 0)
		{
			return result.get(0);
		}
		return null;
	}
	
	public List<Book> readByName(String name)
	{
		return read( "select * from tbl_book where title like %?%", new Object[]{ name });
	}

	@Override
	public Book mapRow(ResultSet resultSet, int arg1) throws SQLException
	{
		Book book = new Book();
		book.setBookId(resultSet.getInt("bookId"));
		book.setAuthor(authorDao.read(resultSet.getInt("authId")));
		book.setPublisher(PublisherDao.read(resultSet.getInt("pubId")));
		book.setTitle(resultSet.getString("title"));
		return book;
	}
}
