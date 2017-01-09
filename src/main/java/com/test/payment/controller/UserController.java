package com.test.payment.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.payment.dao.UserDao;
import com.test.payment.domain.User;
import com.test.payment.domain.UserType;
import com.test.payment.domain.resource.UserResource;
import com.test.payment.exception.InvalidDataException;
import com.test.payment.manager.UserManager;
import com.test.payment.validator.UserValidator;

@RestController("/users")
public class UserController {

	private UserManager manager;

	private UserValidator userValidator;
	
	@Autowired
	public UserController(UserManager manager, UserValidator userValidator) {
		this.manager = manager;
		this.userValidator = userValidator;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(manager.getAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/users/types")
	public ResponseEntity<List<User>> getAllByType(@RequestParam UserType type) {

		return new ResponseEntity<List<User>>(manager.getAllByType(type), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/users")
	public ResponseEntity<?> save(@RequestBody UserResource userResource) {
		try {

			userValidator.validateUser(userResource);

			String result = manager.createUser(new User(null, userResource.getName(), userResource.getFamily(),
					userResource.getBirthDay(), userResource.getSex(), UserType.CUSTOMER, new Date()));
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (InvalidDataException exp) {
			return new ResponseEntity<>(exp.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
