package com.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.quiz.dto.QuizQuestionRequestDto;
import com.learn.quiz.dto.Response;
import com.learn.quiz.entity.QuizQuestion;
import com.learn.quiz.exceptionHandler.CustomException;
import com.learn.quiz.repository.QuizQuestionDao;

@Service
public class QuizQuestionService {

	@Autowired
	private QuizQuestionDao questionDao;

	@Autowired
	private UserService userService;

	public QuizQuestion findById(Long quizQuestionId, String authorization) {
		userService.getUser(authorization);
		QuizQuestion qq = questionDao.findById(quizQuestionId);
		if (qq == null)
			throw new CustomException("QuizQuestion not found.", HttpStatus.BAD_REQUEST);
		else
			return qq;
	}

	public List<QuizQuestion> findByQuizId(Long quizId, String authorization) {
		userService.getUser(authorization);
		return questionDao.findByQuizId(quizId);
	}

	public ResponseEntity<Response> deleteQuizQuestion(Long quizQuestionId, String authorization) {
		userService.getUser(authorization);
		if (questionDao.delete(quizQuestionId) > 0) {
			return new ResponseEntity<Response>(new Response("QuizQuestion deleted successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("QuizQuestion not able to delete."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Response> addQuizQuestion(QuizQuestionRequestDto quizQuestionRequestDto,
			String authorization) {
		userService.getUser(authorization);
		QuizQuestion quizQuestion = new QuizQuestion();
		quizQuestion.setQuizId(quizQuestionRequestDto.getQuizId());
		quizQuestion.setQuestionId(quizQuestionRequestDto.getQuestionId());
		if (questionDao.save(quizQuestion) > 0) {
			return new ResponseEntity<Response>(new Response("Question added successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("Question not able to add."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
