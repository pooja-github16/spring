package com.elibrary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elibrary.model.IssuedBook;

public class RowMapperImplIssuedBook implements RowMapper<IssuedBook> {

	public IssuedBook mapRow(ResultSet rs, int rowNum) throws SQLException {
		IssuedBook ib = new IssuedBook();
		ib.setId(rs.getInt("id"));
		ib.setCallno(rs.getString("callno"));
		ib.setSid(rs.getInt("sid"));
		ib.setSname(rs.getString("sname"));
		ib.setMob(rs.getString("mob"));
		ib.setIssueDate(rs.getString("date"));
		ib.setReturnStatus(rs.getString("return_status"));
		return ib;
	}

}
