package com.gcit.jms.service.messageListener;

import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.jms.entity.Borrower;
import com.gcit.jms.service.AdministratorService;

public class BorrowerMessageListener implements MessageListener
{
	@Autowired
	private AdministratorService adminService;
	
	@Override
	public void onMessage(Message message)
	{
		try
		{
			List<Borrower> borrowerList = (List<Borrower>) ((ObjectMessage) message).getObject();
			for (Borrower b : borrowerList)
			{
				try
				{
					adminService.addBorrower(b);
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
