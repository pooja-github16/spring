package com.techno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techno.model.User;
import com.techno.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	/*
	 * @RequestMapping("/input") public String showForm() { return "input"; }
	 */
	@RequestMapping("/form")
	public String showForm() {
		
		return "form";
	}

	@RequestMapping("/get_form_data")
	public String showFormData(@ModelAttribute("user") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("msg", "You have entered something wrong..");
			System.out.println(user);
			return "form";
		}
		System.out.println(user);
		return "success";
	}

	/*
	 * @ExceptionHandler({IllegalStateException.class,ArrayIndexOutOfBoundsException
	 * .class}) public String handlingException() { return "exception_handle"; }
	 * 
	 */
	@ExceptionHandler(value = IllegalStateException.class)
	public String handlingException(Model m) {

		m.addAttribute("msg", "IllegalStateException occured");
		return "exception_handle";
	}

	@ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
	public String handlingArrayException(Model m) {
		m.addAttribute("msg", "ArrayIndexOutOfBoundsException occured");
		return "exception_handle";
	}

}
