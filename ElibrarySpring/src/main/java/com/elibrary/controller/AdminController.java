package com.elibrary.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elibrary.dao.AdminDao;
import com.elibrary.dao.LibrarianDao;
import com.elibrary.model.Admin;
import com.elibrary.model.Librarian;

@Controller
public class AdminController {
	@Autowired
	AdminDao adminDao;

	@RequestMapping("/login")
	public String showForm() {

		return "login";
	}

	@RequestMapping("/admin_section")
	public String adminSection() {

		return "admin_section";
	}
	@RequestMapping("/admin_logout")
	public String adminLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.setAttribute("adminmail", null);
		session.invalidate();
		return "login";
	}

	@RequestMapping(value = "admin_login", method = RequestMethod.POST)
	public String adminLogin(@ModelAttribute Admin admin, Model model, HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		model.addAttribute("admin", admin);
		System.out.println(admin);
		System.out.println(admin.getEmail() + " " + admin.getPassword());
		if (adminDao.loginCheck(admin)) {
			HttpSession session = request.getSession();
			session.setAttribute("adminmail", admin.getEmail());
			System.out.println("Admin login successfully");
			return "admin_section";
		} else {
			model.addAttribute("msg", "Not valide for login");
			System.out.println("Not Valide for login..");
			return "login";
		}
	}
}
