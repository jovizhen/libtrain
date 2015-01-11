package com.gcit.security;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model)
	{
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "redirect:/login";
	}
	
	//direct or forward doesn't matter in this case, because session will be preserved
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String Login(Model model)
	{
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		GrantedAuthority ga= user.getAuthorities().iterator().next();
		
		if(ga.getAuthority().equals("ROLE_ADMIN"))
		{
			return "redirect:/admin/home";
		}
		else if(ga.getAuthority().equals("ROLE_BOR"))
		{
			return "redirect:/bor/home";
		}
		else if(ga.getAuthority().equals("ROLE_LIB"))
		{
			return "redirect:/lib/home";
		}
		return "";
	}
	
	@RequestMapping(value="/admin/home", method=RequestMethod.GET)
	public String adminHome(Model model)
	{
		return "admin_home";
	}

	@RequestMapping(value="/bor/home", method=RequestMethod.GET)
	public String borHome(Model model)
	{
		return "bor_home";
	}

	@RequestMapping(value="/lib/home", method=RequestMethod.GET)
	public String libHome(Model model)
	{
		return "lib_home";
	}
}
