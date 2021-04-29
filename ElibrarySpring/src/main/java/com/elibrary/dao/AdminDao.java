
package com.elibrary.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elibrary.model.Admin;

@Repository
public class AdminDao {

	@Autowired
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

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

}