package com.egen.usermanagement.service;

import java.util.List;
import com.egen.usermanagement.entities.Users;

/**
 * Implemented During Egen coding Challenge 
 * Created by Goutham Kunduru on 06/27/2017.
 * 
 * @author Goutham Kunduru
 * @version 1.0
 */
public interface UserService {

	void createUser(Users users);

	List<Users> getAllUsers();

	void updateUser(Users users);

	Users findById(int id);

}