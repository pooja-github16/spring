package com.elibrary.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.elibrary.dao.LibrarianDao;
import com.elibrary.model.Librarian;

@Controller
public class LibrarianController {
	@Autowired
	LibrarianDao librarianDao;

	@RequestMapping("/add_librarian")
	public String addLibrarian() {

		return "add_librarian";
	}

	@RequestMapping("/update_librarian")
	public ModelAndView updateLibrarian(ModelAndView model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Librarian librarian = librarianDao.getLibrarian(id);
		model.addObject("librarian", librarian);
		model.setViewName("update_librarian");
		return model;
	}

	@RequestMapping("/view_librarian")
	public ModelAndView viewLibrarian(ModelAndView model) {
		List<Librarian> librarians = librarianDao.getAllLibrarian();
		model.addObject("librarians", librarians);
		model.setViewName("view_librarian");
		return model;
	}

	@RequestMapping("update_librarian_record")
	public String UpdateLibrarianRecord(@ModelAttribute Librarian librarian, Model model) {

		model.addAttribute("librarian", librarian);
		librarianDao.updateLibrarian(librarian);
		return "redirect:/view_librarian";
	}

	@RequestMapping("delete_librarian")
	public String deleteLibrarianRecord(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		librarianDao.deleteLibrarian(id);
		return "redirect:/view_librarian";
	}

	@RequestMapping("add_librarian_record")
	public String addLibrarianRecord(@ModelAttribute Librarian librarian, Model model) {

		model.addAttribute("librarian", librarian);
		System.out.println("within addLibrarianRecord: " + librarian);

		librarianDao.saveLibrarian(librarian);

		return "redirect:/view_librarian";
	}

	@RequestMapping(value = "librarian_login", method = RequestMethod.POST)
	public String librarianLogin(@ModelAttribute Librarian librarian, Model model, HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		model.addAttribute("librarian", librarian);
		System.out.println(librarian);

		if (librarianDao.loginCheck(librarian)) {
			HttpSession session = request.getSession();
			session.setAttribute("librarianemail", librarian.getEmail());
			return "librarian_section";
		} else {
			return "login";
		}
	}

	@RequestMapping("/librarian_logout")
	public String adminLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.setAttribute("librarianemail", null);
		session.invalidate();
		return "login";
	}

}
