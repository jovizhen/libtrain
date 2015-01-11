package com.gcit.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gcit.security.entity.BookLoan;


@Repository("bookLoanDao")
public class BookLoanDao extends BaseDao<BookLoan>
{

	@Autowired
	BookDao bookDao;
	
	@Autowired
	LibraryBranchDao branchDao;
	
	@Autowired
	BorrowerDao borrowerDao;
	
	@Override
	public void create(BookLoan loan) throws ClassNotFoundException, SQLException
	{
		Timestamp outDate=new Timestamp(new Date().getTime());
		long theFuture = System.currentTimeMillis() + (86400 * 7 * 1000);
		Timestamp dueDate=new Timestamp(theFuture);
		save( "insert into tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate) values (?,?,?,?,?)", 
				new Object[]{ loan.getBook().getBookId(), loan.getBranch().getBranchId(), loan.getBorrower().getCardNo(),
			outDate, dueDate});
	}

	@Override
	public void delete(BookLoan loan)
	{
		save( "delete from tbl_book_loans where bookId = (?) and branchId = (?) and cardNo = (?)", 
				new Object[]{ loan.getBook().getBookId(), loan.getBranch().getBranchId(), loan.getBorrower().getCardNo() });
	}

	@Override
	public void update(BookLoan loan) 
	{
		save( "update tbl_book_loans set dueDate = (?) where bookId = (?) and branchId = (?) and cardNo =(?)", 
				new Object[]{ loan.getDueDate(), loan.getBook().getBookId(), 
			loan.getBranch().getBranchId(), loan.getBorrower().getCardNo() });
	}

	@Override
	public List<BookLoan> readAll()
	{
		return read("select * from tbl_book_loans", null);
	}

	public BookLoan read(int bookId, int branchId, int cardNo)
	{
		List<BookLoan> result = read( "select * from tbl_book_loans where bookId = ? and branchId = ? and cardNo = ?", 
				new Object[]{ bookId, branchId, cardNo });

		if (result != null && result.size() != 0)
		{
			return result.get(0);
		}
		return null;
	}
	
	public List<BookLoan> getBookLoanByBorrower(int cardNo)
	{
		return read("select * from tbl_book_loans where cardNo = ?", new Object[] { cardNo });
	}

	@Override
	public BookLoan read(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookLoan mapRow(ResultSet resultSet, int arg1)
			throws SQLException
	{
		BookLoan loan = new BookLoan();
		loan.setBook(bookDao.read(resultSet.getInt("bookId")));
		loan.setBranch(branchDao.read(resultSet.getInt("branchId")));
		loan.setBorrower(borrowerDao.read(resultSet.getInt("cardNo")));
		loan.setDateOut(resultSet.getDate("dateOut"));
		loan.setDueDate(resultSet.getDate("dueDate"));
		return loan;
	}
}
