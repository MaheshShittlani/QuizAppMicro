package com.learn.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.learn.quiz.customException.InfoMessage;
import com.learn.quiz.entity.Question;
import com.learn.quiz.entity.QuizQuestion;
import com.learn.quiz.entity.User;
import com.learn.quiz.exceptionHandler.CustomException;
import com.learn.quiz.repository.QuestionDao;
import com.learn.quiz.repository.QuizQuestionDao;
import com.learn.quiz.repository.UserQuizQuestionAnswerDao;

@Service
public class QuizQuestionService {

	@Autowired
	private QuizQuestionDao quizQuestionDao;

	@Autowired
	private UserQuizQuestionAnswerDao userQuizQuestionAnswerDao;

	@Autowired
	private QuestionDao questionDao;

	@Autowired
	private UserService userService;

	public QuizQuestion findById(Long questionId, String authorization) {
		userService.getUser(authorization);
		QuizQuestion qq = quizQuestionDao.findById(questionId);
		if (qq == null) {
			throw new CustomException("QuizQuestion not found.", HttpStatus.BAD_REQUEST);
		} else {
			return qq;
		}
	}

	public Question getNextQuestion(Long quizId, String authorization) throws InfoMessage {

		User user = userService.getUser(authorization);
		List<QuizQuestion> quizQuestions = quizQuestionDao.findByQuizId(quizId);
		for (QuizQuestion quizQuestion : quizQuestions) {
			if (userQuizQuestionAnswerDao.findByQuizQuestionIdAndUserId(quizQuestion.getId(), user.getId()) == null) {
				return questionDao.findById(quizQuestion.getQuestionId());
			}
		}
		throw new InfoMessage("No more question.");
	}

}
