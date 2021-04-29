package com.elibrary.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.elibrary.dao.BookDao;
import com.elibrary.dao.IssuedBookDao;
import com.elibrary.model.Book;
import com.elibrary.model.IssuedBook;
import com.elibrary.model.Librarian;

@Controller
public class BookController {
	@Autowired
	BookDao bookDao;
	@Autowired
	IssuedBookDao issuedBookDao;

	@RequestMapping("/add_book")
	public String addBook() {
		return "add_book";
	}

	@RequestMapping("/issue_book")
	public String issueBook() {
		return "issue_book";
	}

	@RequestMapping("/return_book_form")
	public String returnBookForm() {
		return "return_book_form";
	}

	@RequestMapping("/add_book_record")
	public String addBookRecord(@ModelAttribute Book book, Model model) {
		model.addAttribute("book", book);
		System.out.println("within addBookRecord: " + book);
		bookDao.saveBook(book);
		return "redirect:/view_book";
	}

	@RequestMapping("/view_book")
	public ModelAndView viewBook(ModelAndView model) {
		List<Book> books = bookDao.getAllBook();
		model.addObject("books", books);
		model.setViewName("view_book");
		return model;
	}

	@RequestMapping(value = "/book_issued", method = RequestMethod.POST)
	public String AddIssuedBook(@ModelAttribute IssuedBook issuedBook, Model model) throws SQLException {
		model.addAttribute("issuedBook", issuedBook);
		System.out.println(issuedBook);
		issuedBook.setReturnStatus("no");
		issuedBookDao.issueBook(issuedBook);
		return "redirect:/issue_book";
	}

	@RequestMapping("/delete_book")
	public String deleteLibrarianRecord(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = bookDao.getBook(id);
		bookDao.deleteBook(book);
		return "redirect:/view_book";
	}

	@RequestMapping("/view_issued_book")
	public ModelAndView viewIssuedBook(ModelAndView model) {
		List<IssuedBook> issuedBooks = issuedBookDao.getAllIssuedBook();
		model.addObject("issuedBooks", issuedBooks);
		model.setViewName("view_issued_book");
		return model;
	}

	@RequestMapping(value = "/return_book", method = RequestMethod.POST)
	public String returnBook( Model model, HttpServletRequest request) {
		String callno=request.getParameter("callno");
		int sid=Integer.parseInt(request.getParameter("sid"));
		try {
		issuedBookDao.returnBook(callno, sid);
		}
		catch(Exception e) {
			System.out.println("Exception in returnBook()::"+e);
			}
		return "redirect:/view_issued_book";

	}

}
