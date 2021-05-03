package com.techno.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techno.model.User;

@Repository
public class UserDao {
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public int saveUser(User user)
	{
		int result =(Integer)template.save(user);
		return result;
	}
	

}
