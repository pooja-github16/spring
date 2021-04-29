package com.elibrary.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elibrary.model.Book;

@Component("bookDao")
public class BookDao {

	@Autowired
	private HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	@Transactional
	public void saveBook(Book book) {
		int result= (Integer) template.save(book);
		System.out.println("result value in saveBook:"+result);
	}
	@Transactional
	public void deleteBook(Book book) {
		template.delete(book);
	}
	@Transactional
	public void updateBook(Book book) {
		template.saveOrUpdate(book);
	}
	@Transactional
	public Book getBook(int id) {
		Book book = template.get(Book.class, id);
		return book;
	}
	public List<Book> getAllBook(){
		List<Book>  books=template.loadAll(Book.class);
		return books;
	}
}
