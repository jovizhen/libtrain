package com.gcit.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gcit.security.entity.Publisher;


@Repository("publisherDao")
public class PublisherDao extends BaseDao<Publisher>
{

	@Override
	public void create(Publisher publisher)
	{
		save("insert into tbl_publisher (publisherName, publisherAddress, publisherPhone) values (?, ?, ?)",
				new Object[]
				{
						publisher.getPublisherName() != null ? publisher
								.getPublisherName() : null,
						publisher.getPublisherAddress() != null ? publisher
								.getPublisherAddress() : null,
						publisher.getPublisherPhone() != null ? publisher
								.getPublisherPhone() : null });
	}

	@Override
	public void delete(Publisher publisher)
	{
		save("delete from tbl_publisher where publisherId = (?)",
				new Object[]
				{ publisher.getPublisherId() });
	}

	@Override
	public void update(Publisher publisher)
	{
		save("update tbl_publisher set publisherName = ?, publisherAddress = ?, "
				+ "publisherPhone = ? where publisherId = ?",
				new Object[]
				{
						publisher.getPublisherName() != null ? publisher
								.getPublisherName() : null,
						publisher.getPublisherAddress() != null ? publisher
								.getPublisherAddress() : null,
						publisher.getPublisherPhone() != null ? publisher
								.getPublisherPhone() : null,
						publisher.getPublisherId() });
	}

	@Override
	public List<Publisher> readAll()
	{
		return read("select * from tbl_publisher",null);
	}


	public Publisher read(int id)
	{
		List<Publisher> result = read(
				"select * from tbl_publisher where publisherId = ?",
				new Object[]
				{ id });
		if (result != null && result.size() != 0)
		{
			return result.get(0);
		}
		return null;
	}

	public List<Publisher> readByName(String name)
	{
		return read(
				"select * from tbl_publisher where publisherName like %?%",
				new Object[]{ name });
	}

	@Override
	public Publisher mapRow(ResultSet resultSet, int arg1) throws SQLException
	{
		Publisher publisher = new Publisher();
		publisher.setPublisherId(resultSet.getInt("publisherId"));
		publisher.setPublisherName(resultSet.getString("publisherName"));
		publisher.setPublisherAddress(resultSet
				.getString("publisherAddress"));
		publisher.setPublisherPhone(resultSet.getString("publisherPhone"));
		return publisher;
	}
}
