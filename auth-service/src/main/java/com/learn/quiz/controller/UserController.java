package com.learn.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.quiz.dto.ChangePasswordDto;
import com.learn.quiz.dto.CreateUserDto;
import com.learn.quiz.dto.LoginDto;
import com.learn.quiz.dto.LoginResponse;
import com.learn.quiz.dto.Response;
import com.learn.quiz.service.LoginSessionService;
import com.learn.quiz.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private LoginSessionService loginSessionService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto) {
		return userService.authenticate(loginDto);
	}

	@PostMapping("/logout")
	public ResponseEntity<Response> logout(@RequestHeader("Authorization") String authorization) {
		return loginSessionService.logout(authorization);
	}

	@PostMapping("/change-password")
	public ResponseEntity<Response> changePassword(@RequestHeader("Authorization") String authorization,
			@RequestBody ChangePasswordDto changePasswordDto) {
		return userService.changePassword(authorization, changePasswordDto);
	}

	@PostMapping("/create-user")
	public ResponseEntity<Response> createUser(@RequestBody CreateUserDto createUserDto) {
		return userService.createUser(createUserDto);
	}
}
