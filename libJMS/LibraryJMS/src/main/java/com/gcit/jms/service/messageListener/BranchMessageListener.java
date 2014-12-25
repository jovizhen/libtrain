package com.gcit.jms.service.messageListener;

import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.jms.entity.LibraryBranch;
import com.gcit.jms.service.AdministratorService;

public class BranchMessageListener implements MessageListener
{
	@Autowired
	private AdministratorService	adminService;

	@Override
	public void onMessage(Message message)
	{
		try
		{
			List<LibraryBranch> branchList = (List<LibraryBranch>) ((ObjectMessage) message).getObject();
			for (LibraryBranch br : branchList)
			{
				try
				{
					adminService.addLibraryBranch(br);
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
