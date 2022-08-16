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

import com.learn.quiz.dto.QuestionRequestDto;
import com.learn.quiz.dto.Response;
import com.learn.quiz.dto.UpdateQuestionRequestDto;
import com.learn.quiz.entity.Question;
import com.learn.quiz.service.QuestionService;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping("/getAllQuestion")
	public List<Question> getAllQuestion(@RequestHeader("Authorization") String authorization) {
		return questionService.findAll(authorization);
	}

	@GetMapping("/get/question/{questionId}")
	public Question getQuestion(@PathVariable Long questionId, @RequestHeader("Authorization") String authorization) {
		return questionService.findById(questionId, authorization);
	}

	@GetMapping("/delete/question/{questionId}")
	public ResponseEntity<Response> deleteQuestion(@PathVariable Long questionId,
			@RequestHeader("Authorization") String authorization) {
		return questionService.deleteQuestion(questionId, authorization);
	}

	@PostMapping("/update/question")
	public ResponseEntity<Response> updateQuestion(@RequestBody UpdateQuestionRequestDto updateQuestionRequestDto,
			@RequestHeader("Authorization") String authorization) {
		return questionService.updateQuestion(updateQuestionRequestDto, authorization);
	}

	@PostMapping("/add/question")
	public ResponseEntity<Response> addQuestion(@RequestBody QuestionRequestDto questionRequestDto,
			@RequestHeader("Authorization") String authorization) {
		return questionService.createQuestion(questionRequestDto, authorization);
	}

}
