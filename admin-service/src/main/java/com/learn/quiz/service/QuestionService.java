package com.learn.quiz.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.learn.quiz.dto.QuestionDto;
import com.learn.quiz.dto.QuestionRequestDto;
import com.learn.quiz.dto.Response;
import com.learn.quiz.dto.UpdateQuestionRequestDto;
import com.learn.quiz.entity.Question;
import com.learn.quiz.exceptionHandler.CustomException;
import com.learn.quiz.repository.QuestionDao;
import com.learn.quiz.utility.ExcelReader;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;

	@Autowired
	private UserService userService;

	public List<Question> findAll(String authorization) {
		userService.getUser(authorization);
		return questionDao.findAllByDeleted('N');
	}

	public Question findById(Long questionId, String authorization) {
		userService.getUser(authorization);
		Question question = questionDao.findById(questionId);
		if (question == null) {
			throw new CustomException("Question not found.", HttpStatus.BAD_REQUEST);
		} else {
			return question;
		}
	}

	public ResponseEntity<Response> deleteQuestion(Long questionId, String authorization) {
		
		if (questionDao.delete(questionId) > 0) {
			return new ResponseEntity<Response>(new Response("Question deleted successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("Question not able to delete."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Response> updateQuestion(UpdateQuestionRequestDto updateQuestionRequestDto,
			String authorization) {
		Question question = findById(updateQuestionRequestDto.getId(), authorization);
		question.setQuestion(updateQuestionRequestDto.getQuestion());
		question.setOptionA(updateQuestionRequestDto.getOptionA());
		question.setOptionB(updateQuestionRequestDto.getOptionB());
		question.setOptionC(updateQuestionRequestDto.getOptionC());
		question.setOptionD(updateQuestionRequestDto.getOptionD());
		question.setRightOption(updateQuestionRequestDto.getRightOption());
		if (questionDao.update(question) > 0) {
			return new ResponseEntity<Response>(new Response("Question updated successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("Question not able to update."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Response> createQuestion(QuestionRequestDto questionRequestDto, String authorization) {
		Question question = new Question();
		question.setQuestion(questionRequestDto.getQuestion());
		question.setOptionA(questionRequestDto.getOptionA());
		question.setOptionB(questionRequestDto.getOptionB());
		question.setOptionC(questionRequestDto.getOptionC());
		question.setOptionD(questionRequestDto.getOptionD());
		question.setRightOption(questionRequestDto.getRightOption());
		if (questionDao.save(question) > 0) {
			return new ResponseEntity<Response>(new Response("Question created successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("Question not able to create."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Response> importQuestions(MultipartFile file, String authorization) throws IOException {
		List<QuestionDto> questionDtos = ExcelReader.getQuestion(file.getInputStream());

		for (QuestionDto questionRequestDto : questionDtos) {
			Question question = new Question();
			question.setQuestion(questionRequestDto.getQuestion());
			question.setOptionA(questionRequestDto.getOptionA());
			question.setOptionB(questionRequestDto.getOptionB());
			question.setOptionC(questionRequestDto.getOptionC());
			question.setOptionD(questionRequestDto.getOptionD());
			question.setRightOption(questionRequestDto.getRightOption());
			if (questionDao.save(question) > 0) {
				return new ResponseEntity<Response>(new Response("Question not able to upload."),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Response>(new Response("Question uploaded successfully."), HttpStatus.OK);

	}

}
