package com.elibrary.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.elibrary.model.IssuedBook;
import com.elibrary.model.Librarian;

@Component
public class IssuedBookDao {

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

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean checkIssue(String callno) throws SQLException {
		System.out.println("checkIssue() start");
		boolean isAvailable = false;
		String query = "select * from book where callno=?";
		PreparedStatement ps = dataSource.getConnection().prepareStatement(query);
		ps.setString(1, callno);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			isAvailable = true;
		}
		return isAvailable;
	}
	
	public void issueBook(IssuedBook issueBook) {
		System.out.println("issueBook() start  "+ issueBook);
		String callno = issueBook.getCallno();
		try {
			boolean isAvailable = checkIssue(callno);
			if (isAvailable) {
				String insertQuery = "insert into issued_book(callno,sid,sname,mob,date,return_status) values(?,?,?,?,?,?)";
				int result = jdbcTemplate.update(insertQuery, issueBook.getCallno(), issueBook.getSid(),
						issueBook.getSname(), issueBook.getMob(), issueBook.getIssueDate(),
						"no");
				System.out.println(result);
				if (result > 0) {
					String updateQuery = "update book set issued=? where callno=?";
					int u = jdbcTemplate.update(updateQuery, getIssued(callno) + 1, callno);
					System.out.println("Updated Book Record :" + u);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int getIssued(String callno) throws SQLException {
		System.out.println("getIssued() start");
		int issued = 0;
		String query = "select * from book where callno=?";
		PreparedStatement ps = dataSource.getConnection().prepareStatement(query);
		ps.setString(1, callno);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			issued = rs.getInt("issued");
		}
		return issued;
	}
	public List getAllIssuedBook() {
		String query="select * from issued_book";
		RowMapperImplIssuedBook rowMapper= new RowMapperImplIssuedBook();
		List<IssuedBook> issuedBooks= jdbcTemplate.query(query, rowMapper);
		return issuedBooks;
		}       
	
	public int returnBook(String callno, int sid)  {
		int status=0;
		try {
		String query1="update issued_book set return_status='yes' where callno=? and sid=? and return_status='no'";
		status=jdbcTemplate.update(query1, callno, sid);
		if(status>0)
		{
			String query2="update book set issued=? where callno=?";
			int result= jdbcTemplate.update(query2, getIssued(callno)-1, callno);
		}
		}
		catch(Exception e) {System.out.println(e);}
		return status;
	}
	
}
