package com.egen.usermanagement.controllers;

import java.io.IOException;
import java.util.List;
import java.text.ParseException;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.egen.usermanagement.entities.Users;
import com.egen.usermanagement.service.UserService;

/**
 * Implemented During Egen coding Challenge Chicago Rest Controller which Enables
 * Various Operations Created by Goutham Kunduru on 06/27/2017.
 * 
 * @author Goutham Kunduru
 * @version 1.0
 */
@RestController
public class UserRestController {
	@Autowired
	UserService userService;

	/**
	 * Description : Add a user if not exists to DB.
	 * 
	 * @param _user
	 *            : take the input as User object.
	 * @return ResponseEntity : response object for rest api.
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping(value = "/createuser", method = RequestMethod.POST, consumes = "*/*;charset=UTF-8")
	public ResponseEntity<String> postUser(@Valid @RequestBody Users users, UriComponentsBuilder uriComponentsBuilder,
			BindingResult result) throws IOException, ParseException {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uriComponentsBuilder.path("/create/").buildAndExpand().toUri());

		if (result.hasErrors() || !validUser(users)) {
			return new ResponseEntity<String>("some errors , Please check ur json content!", httpHeaders,
					HttpStatus.BAD_REQUEST);
		}

		userService.createUser(users);

		return new ResponseEntity<String>("User Created", httpHeaders, HttpStatus.OK);
	}

	/**
	 * Description : Get All users from DB.
	 * 
	 * @return ResponseEntity : response object for rest api.
	 */
	@RequestMapping(value = "/getallusers", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> getAllUsers(UriComponentsBuilder uriComponentsBuilder) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uriComponentsBuilder.path("/getallusers/").buildAndExpand().toUri());
		List<Users> userList = userService.getAllUsers();
		return new ResponseEntity<List<Users>>(userList, httpHeaders, HttpStatus.OK);
	}

	/**
	 * Description : Add a user if not exists to DB.
	 * 
	 * @param _user
	 *            : take the input as User object.
	 * @return ResponseEntity : response object for rest api.
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateuser", method = RequestMethod.PUT, consumes = "*/*;charset=UTF-8")
	public ResponseEntity<String> updateUser(@Valid @RequestBody Users users, UriComponentsBuilder uriComponentsBuilder,
			BindingResult result) throws IOException, ParseException {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uriComponentsBuilder.path("/updateuser/").buildAndExpand().toUri());

		if (result.hasErrors()) {
			return new ResponseEntity<String>("some errors , Please check ur json content!", httpHeaders,
					HttpStatus.BAD_REQUEST);
		}

		Users user = userService.findById(users.getId());

		if (user == null) {
			return new ResponseEntity<String>("User ID Not Found", httpHeaders, HttpStatus.NOT_FOUND);
		}

		userService.updateUser(users);

		return new ResponseEntity<String>("User Updated", httpHeaders, HttpStatus.OK);
	}

	private boolean validUser(Users users) {
		if (users.getAge() > 140 || users.getAge() < 0)
			return false;
		if (!users.getFirstName().matches("[a-zA-Z]+"))
			return false;
		if (!users.getLastName().matches("[a-zA-Z]+"))
			return false;
		if (!(users.getGender().equals("M") || users.getGender().equals("F")))
			return false;
		if (users.getPhone() > 9999999999l || users.getPhone() < 1000000000l)
			return false;
		return true;
	}

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Exception> handleException2(Exception exception) {
		return new ResponseEntity<Exception>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Exception> handleException(MethodArgumentNotValidException exception) {
		return new ResponseEntity<Exception>(exception, HttpStatus.NOT_FOUND);
	}

}
