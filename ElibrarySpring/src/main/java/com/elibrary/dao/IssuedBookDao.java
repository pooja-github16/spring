package com.elibrary.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.elibrary.model.Book;
import com.elibrary.model.IssuedBook;

@Component
public class IssuedBookDao {
	@Autowired
	private HibernateTemplate template;

	@Autowired
	DataSource dataSource;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean checkIssue(String callno) {
		boolean isAvailable = false;
		String query = "select * from book where callno=? and quantity>issued";
		try {
			PreparedStatement ps = dataSource.getConnection().prepareStatement(query);
			ps.setString(1, callno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Book available : ");
				isAvailable = true;
			} else {
				System.out.println("Book is not available..");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return isAvailable;
	}

	public int getIssued(String callno) {
		System.out.println("getIssued() start");
		int issued = 0;
		try {
			String query = "select * from book where callno=?";
			PreparedStatement ps = dataSource.getConnection().prepareStatement(query);
			ps.setString(1, callno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				issued = rs.getInt("issued");
			}
		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}
		return issued;

	}

	@Transactional
	public void issueBook(IssuedBook issueBook) throws SQLException {

		System.out.println("issueBook() start  " + issueBook);
		String callno = issueBook.getCallno();
		boolean isAvailable = checkIssue(callno);
		if (isAvailable) {
			int result = (Integer) template.save(issueBook);
			System.out.println("issuedBook().result: " + result);
			if (result > 0) {
				String query = "update book set issued=? where callno=?";
				PreparedStatement ps = dataSource.getConnection().prepareStatement(query);
				ps.setInt(1, getIssued(callno) + 1);
				ps.setString(2, callno);
				int status = ps.executeUpdate();
			}
		}
	}
	
	@Transactional
	public List<IssuedBook> getAllIssuedBook() {
		List<IssuedBook> issuedBooks = template.loadAll(IssuedBook.class);
		System.out.println(issuedBooks);
		return issuedBooks;
	}
	public  void returnBook(String callno, int sid) throws SQLException {
		
		String query="update issuedbook set returnStatus='yes' where callno=? and sid=? and returnStatus='no'";
		PreparedStatement ps = dataSource.getConnection().prepareStatement(query);
		ps.setString(1, callno);
		 ps.setInt(2, sid);
		int status=ps.executeUpdate();
		 
		  if(status>0)
		  {
			  String uQuery="update book set issued=? where callno=?";
			  PreparedStatement ps2=dataSource.getConnection().prepareStatement(uQuery);
			  ps2.setInt(1, getIssued(callno)-1);
			  ps2.setString(2, callno);
			  status= ps2.executeUpdate();
			  System.out.println("Book return successfully");
		  }
		 
		
	}
}
