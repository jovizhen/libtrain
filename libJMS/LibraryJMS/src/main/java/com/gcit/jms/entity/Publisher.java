package com.gcit.jms.entity;

import java.io.Serializable;

public class Publisher implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private Integer	publisherId;
	private String	publisherName;
	private String	publisherAddress;
	private String	publisherPhone;

	public Publisher()
	{
	}
	
	public Publisher(int publisherId)
	{
		this.publisherId = publisherId;
	}
	
	public Publisher(String publisherName, String publisherAddress, String publisherPhone)
	{
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
		this.publisherPhone = publisherPhone;
	}
	
	public Publisher(Integer publisherId, String publisherName, String publisherAddress, String publisherPhone)
	{
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
		this.publisherPhone = publisherPhone;
	}

	public Integer getPublisherId()
	{
		return publisherId;
	}

	public void setPublisherId(Integer publisherId)
	{
		this.publisherId = publisherId;
	}

	public String getPublisherName()
	{
		return publisherName;
	}

	public void setPublisherName(String publisherName)
	{
		this.publisherName = publisherName;
	}

	public String getPublisherAddress()
	{
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress)
	{
		this.publisherAddress = publisherAddress;
	}

	public String getPublisherPhone()
	{
		return publisherPhone;
	}

	public void setPublisherPhone(String publisherPhone)
	{
		this.publisherPhone = publisherPhone;
	}
}
