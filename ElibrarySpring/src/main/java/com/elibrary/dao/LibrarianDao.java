

package com.elibrary.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elibrary.model.Librarian;

@Repository
public class LibrarianDao {
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

	public boolean loginCheck(Librarian librarian) throws SQLException {
		boolean status = false;
		String query = "select * from librarian where email=? and password=?";
		PreparedStatement ps = dataSource.getConnection().prepareStatement(query);
		ps.setString(1, librarian.getEmail());
		ps.setString(2, librarian.getPassword());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			status = true;
		}
		return status;
	}

	@Transactional
	public int saveLibrarian(Librarian librarian) {
		int result = (Integer) template.save(librarian);
		return result;
	}

	@Transactional
	public void deleteLibrarian(Librarian librarian) {
		template.delete(librarian);
	}

	@Transactional
	public void updateLibrarian(Librarian librarian) {
		template.saveOrUpdate(librarian);
	}

	public Librarian getLibrarian(int id) {
		Librarian librarian = template.get(Librarian.class, id);
		return librarian;
	}

	public List<Librarian> getAllLibrarian() {
		List<Librarian> librarians = template.loadAll(Librarian.class);
		return librarians;
	}
}
