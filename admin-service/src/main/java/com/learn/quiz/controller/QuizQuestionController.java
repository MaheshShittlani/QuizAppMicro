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

import com.learn.quiz.dto.QuizQuestionRequestDto;
import com.learn.quiz.dto.Response;
import com.learn.quiz.entity.QuizQuestion;
import com.learn.quiz.service.QuizQuestionService;

@RestController
@RequestMapping("/api/v1")
public class QuizQuestionController {

	@Autowired
	private QuizQuestionService quizQuestionService;

	@GetMapping("/get/quiz/question/{quizId}")
	public List<QuizQuestion> getQuizQuestion(@PathVariable Long quizId,
			@RequestHeader("Authorization") String authorization) {
		return quizQuestionService.findByQuizId(quizId, authorization);
	}

	@GetMapping("/delete/quiz/question/{quizQuestionId}")
	public ResponseEntity<Response> deleteQuizQuestion(@PathVariable Long quizQuestionId,
			@RequestHeader("Authorization") String authorization) {
		return quizQuestionService.deleteQuizQuestion(quizQuestionId, authorization);
	}

	@PostMapping("/add/quiz/question")
	public ResponseEntity<Response> addQuizQuestion(@RequestBody QuizQuestionRequestDto quizQuestionRequestDto,
			@RequestHeader("Authorization") String authorization) {
		return quizQuestionService.addQuizQuestion(quizQuestionRequestDto, authorization);
	}

}