package com.learn.quiz.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.quiz.dto.ChangePasswordDto;
import com.learn.quiz.dto.CreateUserDto;
import com.learn.quiz.dto.LoginDto;
import com.learn.quiz.dto.LoginResponse;
import com.learn.quiz.dto.Response;
import com.learn.quiz.entity.LoginSession;
import com.learn.quiz.entity.User;
import com.learn.quiz.exceptionHandler.CustomException;
import com.learn.quiz.repository.LoginSessionDao;
import com.learn.quiz.repository.UserDao;
import com.learn.quiz.utility.AES;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private LoginSessionDao loginSessionDao;

	private User getUser(String authorization) {
		LoginSession loginSession = loginSessionDao.findByAccessToken(authorization.split(" ")[1]);
		if (loginSession == null) {
			throw new CustomException("Invalid access.", HttpStatus.UNAUTHORIZED);
		}
		User user = userDao.findById(loginSession.getUserId());
		if (user != null) {
			return user;
		} else {
			throw new CustomException("Invalid access.", HttpStatus.UNAUTHORIZED);
		}
	}

	@Transactional(readOnly = false)
	public ResponseEntity<LoginResponse> authenticate(LoginDto loginDto) throws CustomException {
		User user = userDao.getByEmailIdAndPassword(loginDto.getUserName(), loginDto.getPassword());
		if (user != null) {
			String accessToken = AES.encrypt(user.getId() + user.getEmailId());
			LoginSession loginSession = loginSessionDao.getByUserId(user.getId());
			if (loginSession == null) {
				loginSession = new LoginSession();
				loginSession.setUserId(user.getId());
			}
			loginSession.setAccessToken(accessToken);
			loginSession.setLastAccess(new Date());
			loginSessionDao.save(loginSession);
			return new ResponseEntity<LoginResponse>(new LoginResponse(accessToken), HttpStatus.OK);
		} else {
			throw new CustomException("Invalid username or password.", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Response> changePassword(String authorization, ChangePasswordDto changePasswordDto) {
		User user = getUser(authorization);
		if (!changePasswordDto.getNewPassword().equals(changePasswordDto.getRetypePassword())) {
			return new ResponseEntity<Response>(new Response("New Password and Retype Password should be same."),
					HttpStatus.BAD_REQUEST);
		} else {
			if (changePasswordDto.getCurrentPassword() == null) {
				return new ResponseEntity<Response>(new Response("User not exists, Please login again."),
						HttpStatus.BAD_REQUEST);
			} else if (!user.getPassword().equals(changePasswordDto.getCurrentPassword())) {
				return new ResponseEntity<Response>(new Response("Invalid Password."), HttpStatus.BAD_REQUEST);
			} else {
				if (userDao.updatePassword(user.getId(), changePasswordDto.getNewPassword()) > 0) {
					return new ResponseEntity<Response>(
							new Response("Password has changed successfully, You need to login again."), HttpStatus.OK);
				} else {
					return new ResponseEntity<Response>(new Response("Internal Server Error."),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		}
	}

	public ResponseEntity<Response> createUser(CreateUserDto createUserDto) {
		User user = new User(null, createUserDto.getFirstName(), createUserDto.getLastName(),
				createUserDto.getEmailId(), createUserDto.getPassword(), createUserDto.getMobileNumber(), 'N',
				new Date(), new Date());
		if (userDao.save(user) > 0) {
			return new ResponseEntity<Response>(new Response("User created successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("Unable to create user."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
