package com.learn.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.quiz.customException.InfoMessage;
import com.learn.quiz.dto.Response;
import com.learn.quiz.dto.SubmitQuestion;
import com.learn.quiz.dto.UserScore;
import com.learn.quiz.entity.Question;
import com.learn.quiz.service.QuizQuestionService;
import com.learn.quiz.service.UserQuizQuestionAnswerService;

@RestController
@RequestMapping("/api/v1")
public class QuizController {

	@Autowired
	private QuizQuestionService quizQuestionService;

	@Autowired
	private UserQuizQuestionAnswerService userQuizQuestionAnswerService;

	@GetMapping("/get/quiz/next/question/{quizId}")
	public Question getNextQuizQuestion(@PathVariable Long quizId, @RequestHeader("Authorization") String authorization)
			throws InfoMessage {
		return quizQuestionService.getNextQuestion(quizId, authorization);
	}

	@PostMapping("/submit/question")
	public ResponseEntity<Response> submitQuestion(@RequestBody SubmitQuestion submitQuestion,
			@RequestHeader("Authorization") String authorization) {
		return userQuizQuestionAnswerService.createUserQuizQuestionAnswer(submitQuestion, authorization);
	}

	@GetMapping("/leaderBoard/{quizId}")
	public List<UserScore> leaderBoard(@PathVariable Long quizId,
			@RequestHeader("Authorization") String authorization) {
		return userQuizQuestionAnswerService.getLeaderBoard(quizId);
	}
}
