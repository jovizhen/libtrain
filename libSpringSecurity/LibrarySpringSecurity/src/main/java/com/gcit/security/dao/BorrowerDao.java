package com.gcit.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gcit.security.entity.Borrower;

@Repository("borrowerDao")
public class BorrowerDao extends BaseDao<Borrower>
{
	@Override
	public void create(Borrower borrower)
	{
		save("insert into tbl_borrower (name, address, phone) values (?,?,?)",
				new Object[]
				{
						(borrower.getName() == null) ? null : borrower
								.getName(),
						(borrower.getAddress() == null) ? null : borrower
								.getAddress(),
						(borrower.getPhone() == null) ? null : borrower
								.getPhone() });
	}

	@Override
	public void delete(Borrower borrower) 
	{
		String sql = "delete from tbl_borrower where cardNo = (?)";
		Object[] vals = { borrower.getCardNo() };
		save(sql, vals);
	}

	@Override
	public void update(Borrower borrower) 
	{
		save("update tbl_borrower set name = ?, address = ?, phone = ? where cardNo = ?",
				new Object[]
				{
						(borrower.getName() == null) ? null : borrower
								.getName(),
						(borrower.getAddress() == null) ? null : borrower
								.getAddress(),
						(borrower.getPhone() == null) ? null : borrower
								.getPhone(), borrower.getCardNo() });
	}

	@Override
	public List<Borrower> readAll()
	{
		return read("select * from tbl_borrower", null);
	}

	public Borrower read(int id)
	{
		List<Borrower> result = read(
				"select * from tbl_borrower where cardNo = ?",
				new Object[]
				{ id });
		if (result != null && result.size() != 0)
		{
			return result.get(0);
		}
		return null;
	}

	public List<Borrower> readByName(String name)
	{
		List<Borrower> result = read(
				"select * from tbl_borrower where name = ?", new Object[]
				{ name });
		return result;
	}

	@Override
	public Borrower mapRow(ResultSet resultSet, int arg1)
			throws SQLException
	{
		Borrower borrower = new Borrower();
		borrower.setCardNo(resultSet.getInt("cardNo"));
		borrower.setName(resultSet.getString("name"));
		borrower.setAddress(resultSet.getString("address"));
		borrower.setPhone(resultSet.getString("phone"));
		return borrower;
	}
}
