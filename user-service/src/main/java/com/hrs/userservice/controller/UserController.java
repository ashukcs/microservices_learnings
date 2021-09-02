package com.hrs.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrs.userservice.payload.UserPayload;
import com.hrs.userservice.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/userService")
@Api(value = "/userService", tags="User Management")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	@PostMapping(value = "/addUser")
	@ApiOperation(value = "Create User", notes = "Create New User", tags = {"User Management"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "User Created Successfully!"),
			@ApiResponse(code = 404, message = "Invalid Data!"),
			@ApiResponse(code = 500, message = "Invalid Server Error!")
	})
	public ResponseEntity<UserPayload> createUser(@RequestBody UserPayload user) {
		try {
			logger.info("User Service createUser request : {}", new ObjectMapper().writeValueAsString(user));
			user = userService.createUser(user);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping(value = "/updateUser")
	public ResponseEntity<UserPayload> updateUser(@RequestBody UserPayload user) {
		try {
			logger.info("User Service updateUser request : {}", new ObjectMapper().writeValueAsString(user));
			user = userService.createUser(user);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping(value = "/getUser/{userId}")
	@ApiOperation(value = "Get User", notes = "Get User Details", tags = {"User Management"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "User Retrieved Successfully!"),
			@ApiResponse(code = 404, message = "Invalid Data!"),
			@ApiResponse(code = 500, message = "Internal Server Error!")
	})
	public ResponseEntity<UserPayload> getUser(@PathVariable String userId) {
		UserPayload userPayload = null;
		try {
			logger.info("User Service getUser request : {}", userId);
			userPayload = userService.getUser(userId);
		} catch (Exception e) {
			logger.error("Getting Error while fetching users from getUser request : {}", e.fillInStackTrace());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(userPayload, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteUser/{userId}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable String userId) {
		try {
			logger.info("User Service deleteUser request : {}", userId);
			userService.deleteUser(userId);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
