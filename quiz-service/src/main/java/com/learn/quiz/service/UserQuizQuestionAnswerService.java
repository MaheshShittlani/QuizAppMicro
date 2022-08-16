package com.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.quiz.dto.Response;
import com.learn.quiz.dto.SubmitQuestion;
import com.learn.quiz.dto.UserScore;
import com.learn.quiz.entity.QuizQuestion;
import com.learn.quiz.entity.User;
import com.learn.quiz.entity.UserQuizQuestionAnswer;
import com.learn.quiz.exceptionHandler.CustomException;
import com.learn.quiz.repository.QuizQuestionDao;
import com.learn.quiz.repository.UserQuizQuestionAnswerDao;

@Service
public class UserQuizQuestionAnswerService {

	@Autowired
	private UserQuizQuestionAnswerDao userQuizQuestionAnswerDao;

	@Autowired
	private QuizQuestionDao quizQuestionDao;

	@Autowired
	private UserService userService;

	public List<UserQuizQuestionAnswer> findAll() {
		return userQuizQuestionAnswerDao.findAll();
	}

	public UserQuizQuestionAnswer findById(Long userQuizQuestionAnswerId, String authorization) {
		userService.getUser(authorization);
		UserQuizQuestionAnswer answer = userQuizQuestionAnswerDao.findById(userQuizQuestionAnswerId);
		if (answer == null) {
			throw new CustomException("UserQuizQuestionAnswer not found.", HttpStatus.BAD_REQUEST);
		} else {
			return answer;
		}
	}

	public ResponseEntity<Response> createUserQuizQuestionAnswer(SubmitQuestion submitQuestion, String authorization) {
		User user = userService.getUser(authorization);
		QuizQuestion quizQuestion = quizQuestionDao.findByQuizIdAndQuestionId(submitQuestion.getQuizId(),
				submitQuestion.getQuestionId());
		UserQuizQuestionAnswer userQuizQuestionAnswer = new UserQuizQuestionAnswer();
		userQuizQuestionAnswer.setUserId(user.getId());
		userQuizQuestionAnswer.setQuizQuestionId(quizQuestion.getId());
		userQuizQuestionAnswer.setSelectedOption(submitQuestion.getAnswer());
		if (userQuizQuestionAnswerDao.save(userQuizQuestionAnswer) > 0) {
			return new ResponseEntity<Response>(new Response("Answer submitted successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("Answer not able to submit."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public List<UserScore> getLeaderBoard(Long quizId) {
		return userQuizQuestionAnswerDao.getLeaderBoard(quizId);
	}

}
