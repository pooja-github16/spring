 package com.elibrary.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.elibrary.model.Librarian;

@Component("librarianDao")
public class LibrarianDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void saveLibrarian(Librarian librarian) {
		System.out.println(librarian.getName());
		String query1 = "insert into librarian(name,email,password,mob) values(?,?,?,?)";
		int result = jdbcTemplate.update(query1, librarian.getName(), librarian.getEmail(), librarian.getPassword(),
				librarian.getMob());
		System.out.println(result + " rows inserted");
	}

	public void updateLibrarian(Librarian librarian) {
		String query2 = "update librarian set name=?, email=?,password=?,mob=? where id=?";
		int result = jdbcTemplate.update(query2, librarian.getName(), librarian.getEmail(), librarian.getPassword(),
				librarian.getMob(), librarian.getId());
		
		System.out.println(result + " rows updated.");

	}

	public void deleteLibrarian(int id) {
		String query3 = "delete from librarian where id=?";
		int result = jdbcTemplate.update(query3, id);
		System.out.println(result + " rows deleted");
	}

	public Librarian getLibrarian(int id) {
		String query4 = "select * from librarian where id=?";
		RowMapperImplLibrarian rowMapper = new RowMapperImplLibrarian();
		Librarian librarian = jdbcTemplate.queryForObject(query4, rowMapper, id);
		System.out.println(librarian);
		return librarian;
	}

	public List getAllLibrarian() {
		String query5 = "select * from librarian";
		RowMapperImplLibrarian rowMapper = new RowMapperImplLibrarian();
		List<Librarian> librarians = jdbcTemplate.query(query5, rowMapper);
		System.out.println(librarians);
		return librarians;
	}
	public boolean loginCheck(Librarian librarian) throws SQLException {
		boolean status=false;
		String query ="select * from librarian where email=? and password=?";
		PreparedStatement ps= dataSource.getConnection().prepareStatement(query);
		ps.setString(1, librarian.getEmail());
		ps.setString(2, librarian.getPassword());
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			status=true;
		}
		return status;
	}
	/*
	public boolean loginCheck(Admin admin) throws SQLException {
		boolean status = false;
		String query = "select * from admin where email=? and password=?";
		PreparedStatement ps = dataSource.getConnection().prepareStatement(query);
		ps.setString(1, admin.getEmail());
		ps.setString(2, admin.getPassword());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			status = true;
		}
		return status;

	}
*/
}
