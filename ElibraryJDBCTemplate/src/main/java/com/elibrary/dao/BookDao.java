package com.elibrary.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.elibrary.model.Book;
import com.elibrary.model.Librarian;

@Component("bookDao")
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void saveBook(Book book)
	{
		
		String insertQuery="insert into book(callno,name,author,publisher,quantity,issued) values(?,?,?,?,?,?)";
		int result = jdbcTemplate.update(insertQuery, book.getCallno(),book.getName(),book.getAuthor(),book.getPublisher(),book.getQuantity(),book.getIssued());
		System.out.println(result);
	}
	
	public void updateBook(Book book)
	{
		String updateQuery ="update book set callno=?,name=?,author=?,publisher=?,quantity=?,issued=? where id=?";
		int result=jdbcTemplate.update(updateQuery, book.getCallno(),book.getName(),book.getAuthor(),book.getPublisher(),book.getQuantity(),book.getIssued(),book.getId());
		System.out.println(result + " rows updated.");
	}
	
	public void deleteBook(int id){
		String deleteQuery="delete from book where id=?";
		int result = jdbcTemplate.update(deleteQuery,id);
		System.out.println(result + " rows deleted");
	}
	
	public Book getBook(int id) {
		String selectQuery="select * from book where id=?";
		RowMapperImplBook rowMapper = new RowMapperImplBook();
		Book book = jdbcTemplate.queryForObject(selectQuery, rowMapper,id);
		return book;
	}
	
	public List getAllBook() {
		String selectAllQuery="select * from book";
		RowMapperImplBook rowMapper= new RowMapperImplBook();
		List<Book> books= jdbcTemplate.query(selectAllQuery, rowMapper);
		return books;
	}	
}
