package com.learn.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.quiz.dto.Response;
import com.learn.quiz.dto.UpdateUserDto;
import com.learn.quiz.entity.User;
import com.learn.quiz.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/update-profile")
	public ResponseEntity<Response> createUser(@RequestBody UpdateUserDto updateUserDto,
			@RequestHeader("Authorization") String authorization) {
		return userService.updateProfile(updateUserDto, authorization);
	}

	@GetMapping("/get/profile")
	public User getUser(@RequestHeader("Authorization") String authorization) {
		return userService.getUser(authorization);
	}
}
