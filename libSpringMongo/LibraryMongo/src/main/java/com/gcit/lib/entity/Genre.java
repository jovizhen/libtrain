package com.gcit.lib.entity;

import org.springframework.data.annotation.Id;

public class Genre
{
	@Id
	private String id;
	
	private String genreName;


	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getGenreName()
	{
		return genreName;
	}

	public void setGenreName(String genreName)
	{
		this.genreName = genreName;
	}
}
