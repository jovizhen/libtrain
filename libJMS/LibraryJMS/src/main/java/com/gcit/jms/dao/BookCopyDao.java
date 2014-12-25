package com.gcit.jms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.jms.entity.BookCopy;



public class BookCopyDao extends BaseDao<BookCopy>
{
	@Autowired
	BookDao bookDao;
	
	@Autowired
	LibraryBranchDao branchDao;
	
	@Override
	public void create(BookCopy copy)
	{
		save("insert into tbl_book_copies (bookId, branchId, noOfCopies) values (?, ?, ?)", new Object[]
		{ copy.getBook().getBookId(), copy.getBranch().getBranchId(), copy.getNoOfCopies() });
	}

	@Override
	public void delete(BookCopy copy) 
	{
		save("delete from tbl_book_copies where bookId = (?) and branchId = (?)", new Object[]
		{ copy.getBook().getBookId(), copy.getBranch().getBranchId() });
	}

	@Override
	public void update(BookCopy copy)
	{
		save("update tbl_book_copies set noOfCopies = (?) where bookId = (?) and branchId = (?)", new Object[]
		{ copy.getNoOfCopies(), copy.getBook().getBookId(), copy.getBranch().getBranchId() });
	}

	@Override
	public List<BookCopy> readAll()
	{
		return read("select * from tbl_book_copies", null);
	}

	public BookCopy read(int bookId, int branchId)
	{
		List<BookCopy> result = read("select * from tbl_book_copies where bookId = ? and branchId = ?", new Object[]
		{ bookId, branchId });
		if (result != null && result.size() != 0)
		{
			return result.get(0);
		}
		return null;
	}
	
	public List<BookCopy> readByBranch(int branchId) 
	{
		List<BookCopy> result = read(
				"select * from tbl_book_copies where branchId = ?", 
				new Object[]{ branchId });
		return result;
	}

	@Override
	public BookCopy read(int id) 
	{
		return null;
	}

	@Override
	public BookCopy mapRow(ResultSet resultSet, int arg1) throws SQLException
	{
		BookCopy copy = new BookCopy();
		copy.setBook(bookDao.read(resultSet.getInt("bookId")));
		copy.setBranch(branchDao.read(resultSet.getInt("branchId")));
		copy.setNoOfCopies(resultSet.getInt("noOfCopies"));
		return copy;
	}
}
