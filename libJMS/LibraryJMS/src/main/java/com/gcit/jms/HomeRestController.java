package com.gcit.jms;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.jms.entity.Author;
import com.gcit.jms.service.AdministratorService;


@RestController
public class HomeRestController {

	@Autowired
	private AdministratorService adminService;


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		return "index";
	}

	@RequestMapping(value = "/showAddAuthor")
	public String showAddAuthor(Locale locale, Model model) {
		model.addAttribute("author", new Author());
		return "addAuthor";
	}

	@RequestMapping(value = "/addAuthorAction/{authorName}", headers = "Accept=application/json")
	public String addAuthorAction(Author author) {
		try {
			adminService.addAuthor(author);
			return "Author Added Succesfully!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Author Add Failed!";
		}
	}
	
	@RequestMapping(value = "/deleteAuthorAction/{authorId}", headers = "Accept=application/json")
	public String deleteAuthorAction(Author author) {
		try {
			adminService.deleteAuthor(author);
			return "Author Deleted Succesfully!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Author Delete Failed!";
		}
	}

	@RequestMapping(value = "/showAuthorsListRest", headers = "Accept=application/json")
	public List<Author> showAuthorsList() {
		try {
			return adminService.getAllAuthors();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
