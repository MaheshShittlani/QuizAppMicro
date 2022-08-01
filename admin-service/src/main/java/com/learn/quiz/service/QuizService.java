package com.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.quiz.dto.QuizRequestDto;
import com.learn.quiz.dto.Response;
import com.learn.quiz.dto.UpdateQuizRequestDto;
import com.learn.quiz.entity.Quiz;
import com.learn.quiz.exceptionHandler.CustomException;
import com.learn.quiz.repository.QuizDao;

@Service
public class QuizService {

	@Autowired
	private QuizDao quizDao;

	@Autowired
	private UserService userService;

	public List<Quiz> findAll(String authorization) {
		userService.getUser(authorization);
		return quizDao.findAllByDeleted('N');
	}

	public Quiz findById(Long quizId, String authorization) {
		userService.getUser(authorization);
		Quiz quiz = quizDao.findById(quizId);
		if (quiz == null)
			throw new CustomException("Quiz not found.", HttpStatus.BAD_REQUEST);
		else
			return quiz;
	}

	public ResponseEntity<Response> deleteQuiz(Long quizId, String authorization) {
		Quiz quiz = findById(quizId, authorization);
		quiz.setDeleted('Y');
		if (quizDao.save(quiz) > 0) {
			return new ResponseEntity<Response>(new Response("Quiz deleted successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("Quiz not able to delete."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Response> updateQuiz(UpdateQuizRequestDto updateQuizRequestDto, String authorization) {
		Quiz quiz = findById(updateQuizRequestDto.getId(), authorization);
		quiz.setTitle(updateQuizRequestDto.getTitle());
		quiz.setCategory(updateQuizRequestDto.getCategory());
		if (quizDao.save(quiz) > 0) {
			return new ResponseEntity<Response>(new Response("Quiz updated successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("Quiz not able to update."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Response> createQuiz(QuizRequestDto quizRequestDto, String authorization) {
		userService.getUser(authorization);
		Quiz quiz = new Quiz();
		quiz.setTitle(quizRequestDto.getTitle());
		quiz.setCategory(quizRequestDto.getCategory());
		if (quizDao.save(quiz) > 0) {
			return new ResponseEntity<Response>(new Response("Quiz created successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("Quiz not able to create."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
