package com.elibrary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elibrary.model.Librarian;

public class RowMapperImplLibrarian implements RowMapper<Librarian>{

	public Librarian mapRow(ResultSet rs, int rowNum) throws SQLException {
		Librarian l= new Librarian();
		l.setId(rs.getInt("id"));
		l.setName(rs.getString("name"));
		l.setEmail(rs.getString("email"));
		l.setPassword(rs.getString("password"));
		l.setMob(rs.getLong("mob"));
		return l;
	}

}
