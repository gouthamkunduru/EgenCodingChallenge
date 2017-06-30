package com.egen.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.usermanagement.dao.UserDao;
import com.egen.usermanagement.entities.Users;

/**
 * Implemented During Egen coding Challenge
 *  Created by Goutham Kunduru on 06/27/2017.
 * 
 * @author Goutham Kunduru
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public void createUser(Users users) {
		// TODO Auto-generated method stub
		userDao.createUser(users);
	}

	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	public void updateUser(Users users) {
		// TODO Auto-generated method stub
		userDao.updateUser(users);
	}

	public Users findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

}
