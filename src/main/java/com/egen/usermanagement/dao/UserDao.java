package com.egen.usermanagement.dao;

import java.util.List;
import java.util.UUID;

import com.egen.usermanagement.entities.Users;

/**
 * Implemented During Egen coding Challenge 
 * Created by Goutham Kunduru on 06/27/2017.
 * 
 * @author Goutham Kunduru
 * @version 1.0
 */

public interface UserDao {

	void createUser(Users users);

	List<Users> getAllUsers();

	void updateUser(Users users);

	Users findById(UUID id);
}