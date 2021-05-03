package com.elibrary.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.elibrary.model.Admin;

@Component("adminDao")
public class AdminDao {

	@Autowired
	private static JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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

		/*
		 * String query1= "select * from admin where email=? and password=?";
		 * System.out.println(query1); RowMapperImplAdmin rowMapper= new
		 * RowMapperImplAdmin(); Admin a= (Admin)
		 * jdbcTemplate.query(query1,"admin@abc.com","admin", rowMapper);
		 * System.out.println(rowMapper+" "+a); if(a !=null) { status=true; }
		 */

		return status;

	}
	
}
