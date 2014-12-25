package com.gcit.jms.service.messageListener;

import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.jms.entity.Author;
import com.gcit.jms.service.AdministratorService;


@Service
public class AuthorMessageListener 
		implements MessageListener {
	
	@Autowired
	private AdministratorService adminService;
	
	@Override
	public void onMessage(Message message) {
		try {
//			if(((ObjectMessage) message).getObject() instanceof List) {
//				Object o = ((List) ((ObjectMessage) message).getObject()).get(0);
//				if(o instanceof Book){
					List<Author> authorList = (List<Author>) ((ObjectMessage) message).getObject();
					for(Author a : authorList) {
						try {
							adminService.addAuthor(a);
							//put into database succes of author a
						} catch(Exception e) {
							//put into database failure of author a
						}
						
					}
//				}
//			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
