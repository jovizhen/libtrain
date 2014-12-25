package com.gcit.jms.entity;

import java.io.Serializable;

public class Author implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private int	authorId;
	private String	authorName;

	public Author()
	{
	}
	
	public Author(int authorId)
	{
		this.authorId = authorId;
	}
	
	public Author(String authorName)
	{
		this.authorName = authorName;
	}
	
	public Author(Integer authorId, String authorName)
	{
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}

	public int getAuthorId()
	{
		return authorId;
	}

	public void setAuthorId(int authorId)
	{
		this.authorId = authorId;
	}

	public String getAuthorName()
	{
		return authorName;
	}

	public void setAuthorName(String authorName)
	{
		this.authorName = authorName;
	}
}
