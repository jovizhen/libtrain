package com.gcit.jms.service.messageListener;

import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.jms.entity.Publisher;
import com.gcit.jms.service.AdministratorService;

@Service
public class PublisherMessageListener implements MessageListener
{
	@Autowired
	private AdministratorService adminService;

	@Override
	public void onMessage(Message message)
	{
		try
		{
			List<Publisher> pubList = (List<Publisher>) ((ObjectMessage) message).getObject();
			for (Publisher p : pubList)
			{
				try
				{
					adminService.addPublisher(p);
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
