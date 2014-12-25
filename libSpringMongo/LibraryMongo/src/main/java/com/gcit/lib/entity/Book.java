package com.gcit.lib.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Book
{

	@Id
	private String			id;

	private String			title;

	private List<Author>	authors;
	
	private List<Genre>     genres;
	
	private Publisher		publisher;

	public String getId()
	{
		return id;
	}

	public void setId(String bookId)
	{
		this.id = bookId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public List<Author> getAuthors()
	{
		return authors;
	}

	public void setAuthors(List<Author> authors)
	{
		this.authors = authors;
	}

	public List<Genre> getGenres()
	{
		return genres;
	}

	public void setGenres(List<Genre> genres)
	{
		this.genres = genres;
	}

	public Publisher getPublisher()
	{
		return publisher;
	}

	public void setPublisher(Publisher publisher)
	{
		this.publisher = publisher;
	}
	
	public String getAuthorString()
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < authors.size(); i++)
		{
			if (i == authors.size() - 1)
				sb.append(authors.get(i).getAuthorName());
			else
				sb.append(authors.get(i).getAuthorName()).append("/");
		}
		return sb.toString();
	}
	
	public String getGenreString()
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < genres.size(); i++)
		{
			if (i == genres.size() - 1)
				sb.append(genres.get(i).getGenreName());
			else
				sb.append(genres.get(i).getGenreName()).append("/");
		}
		return sb.toString();
	}
}
