package com.egen.usermanagement.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egen.usermanagement.entities.Users;

/**
 * Implemented During Egen coding Challenge 
 * Created by Goutham Kunduru on 06/27/2017.
 * 
 * @author Goutham Kunduru
 * @version 1.0
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory session;

	public void createUser(Users users) {
		// TODO Auto-generated method stub
		session.getCurrentSession().persist(users);
	}

	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers() {
		return session.getCurrentSession().createQuery("from Users").list();
	}

	public void updateUser(Users users) {
		session.getCurrentSession().saveOrUpdate(users);
	}

	public Users findById(int id) {
		// TODO Auto-generated method stub
		Users user = (Users) session.getCurrentSession().get(Users.class, id);
		return user;
	}
}