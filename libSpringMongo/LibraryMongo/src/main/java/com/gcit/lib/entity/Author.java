package com.gcit.lib.entity;


import org.springframework.data.annotation.Id;

public class Author
{

	@Id
	private String	id;
	private String	authorName;
	private int		authorPhone;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getAuthorName()
	{
		return authorName;
	}

	public void setAuthorName(String authorName)
	{
		this.authorName = authorName;
	}

	public int getAuthorPhone()
	{
		return authorPhone;
	}

	public void setAuthorPhone(int authorPhone)
	{
		this.authorPhone = authorPhone;
	}
}
