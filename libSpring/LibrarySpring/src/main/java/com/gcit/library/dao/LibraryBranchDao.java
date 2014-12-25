package com.gcit.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcit.library.dao.domain.LibraryBranch;


public class LibraryBranchDao extends BaseDao<LibraryBranch>
{

	@Override
	public void create(LibraryBranch branch) 
	{
		save("insert into tbl_library_branch (branchName, branchAddress) values (?,?)",
				new Object[]
				{
						(branch.getBranchName() == null) ? null : branch
								.getBranchName(),
						(branch.getBranchAddress() == null) ? null
								: branch.getBranchAddress() });
	}

	@Override
	public void delete(LibraryBranch branch)
	{
		save("delete from tbl_library_branch where branchId = (?)",
				new Object[]
				{ branch.getBranchId() });
	}

	@Override
	public void update(LibraryBranch branch) 
	{
		save("update tbl_library_branch set branchName = (?), branchAddress = (?) where branchId = (?)",
				new Object[]
				{
						(branch.getBranchName() == null) ? null : branch
								.getBranchName(),
						(branch.getBranchAddress() == null) ? null
								: branch.getBranchAddress(),
						branch.getBranchId() });
	}

	@Override
	public List<LibraryBranch> readAll()
	{
		return read("select * from tbl_library_branch", null);
	}

	public LibraryBranch read(int id)
	{
		List<LibraryBranch> result = read( 
				"select * from tbl_library_branch where branchId = ?", 
				new Object[]{ id });
		if (result != null && result.size() != 0)
		{
			return result.get(0);
		}
		return null;
	}
	
	public List<LibraryBranch> readByName(String name)
	{
		return read(
				"select * from tbl_library_branch where branchName like %?%",
				new Object[]{ name });
	}

	@Override
	public LibraryBranch mapRow(ResultSet resultSet, int arg1)
			throws SQLException
	{
		LibraryBranch branch = new LibraryBranch();
		branch.setBranchId(resultSet.getInt("branchId"));
		branch.setBranchName(resultSet.getString("branchName"));
		branch.setBranchAddress(resultSet.getString("branchAddress"));
		return branch;
	}
}
