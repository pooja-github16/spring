package com.elibrary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elibrary.model.Admin;

public class RowMapperImplAdmin implements RowMapper<Admin>  {

	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		admin.setId(rs.getInt("id"));
		admin.setEmail(rs.getString("email"));
		admin.setPassword(rs.getString("password"));
		return admin;
	}

}
