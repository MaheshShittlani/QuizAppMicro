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

import com.learn.quiz.dto.QuizRequestDto;
import com.learn.quiz.dto.Response;
import com.learn.quiz.dto.UpdateQuizRequestDto;
import com.learn.quiz.entity.Quiz;
import com.learn.quiz.service.QuizService;

@RestController
@RequestMapping("/api/v1")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@GetMapping("/getAllQuiz")
	public List<Quiz> getAllQuiz(@RequestHeader("Authorization") String authorization) {
		return quizService.findAll(authorization);
	}

	@GetMapping("/get/quiz/{quizId}")
	public Quiz getQuiz(@PathVariable Long quizId, @RequestHeader("Authorization") String authorization) {
		return quizService.findById(quizId, authorization);
	}

	@GetMapping("/delete/quiz/{quizId}")
	public ResponseEntity<Response> deleteQuiz(@PathVariable Long quizId, @RequestHeader("Authorization") String authorization) {
		return quizService.deleteQuiz(quizId, authorization);
	}

	@PostMapping("/update/quiz")
	public ResponseEntity<Response> updateQuiz(@RequestBody UpdateQuizRequestDto updateQuizRequestDto, @RequestHeader("Authorization") String authorization) {
		return quizService.updateQuiz(updateQuizRequestDto, authorization);
	}

	@PostMapping("/create/quiz")
	public ResponseEntity<Response> createQuiz(@RequestBody QuizRequestDto quizRequestDto, @RequestHeader("Authorization") String authorization) {
		return quizService.createQuiz(quizRequestDto, authorization);
	}

}
