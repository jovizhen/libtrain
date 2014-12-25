package com.gcit.jms.service.messageListener;

import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.jms.entity.Book;
import com.gcit.jms.service.AdministratorService;

public class BookMessageListener implements MessageListener
{
	@Autowired
	AdministratorService	adminService;

	@Override
	public void onMessage(Message message)
	{
		try
		{
			List<Book> bookList = (List<Book>) ((ObjectMessage) message).getObject();
			for (Book b : bookList)
			{
				try
				{
					adminService.addBook(b);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		} 
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
	}

}
