package com.elibrary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elibrary.model.Book;



public class RowMapperImplBook implements RowMapper<Book> {

	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book b= new Book();
		b.setId(rs.getInt("id"));
		b.setCallno(rs.getString("callno"));
		b.setName(rs.getString("name"));
		b.setAuthor(rs.getString("author"));
		b.setPublisher(rs.getString("publisher"));
		b.setQuantity(rs.getInt("quantity"));
		b.setIssued(rs.getInt("issued"));
		
		return b;
	}
	
}
