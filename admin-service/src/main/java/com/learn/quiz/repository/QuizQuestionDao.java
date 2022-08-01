package com.learn.quiz.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.quiz.entity.QuizQuestion;

@Repository
public class QuizQuestionDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<QuizQuestion> findByQuizId(Long quizId) {
		return jdbcTemplate.query("SELECT q.* from quiz_question q where q.quiz_id = ? and q.deleted = 'N'",
				new BeanPropertyRowMapper<QuizQuestion>(QuizQuestion.class), new Object[] { quizId });
	}

	public int save(QuizQuestion quizQuestion) {
		return jdbcTemplate.update(
				"INSERT INTO `quiz`.`quiz_question` ( `quiz_id`, `question_id`, `deleted`) VALUES (?, ?, 'N' )",
				new Object[] { quizQuestion.getQuizId(), quizQuestion.getQuestionId() });
	}

	public QuizQuestion findById(Long quizQuestionId) {
		List<QuizQuestion> rs = jdbcTemplate.query("SELECT q.* from quiz_question q where q.id = ? and q.deleted = 'N'",
				new BeanPropertyRowMapper<QuizQuestion>(QuizQuestion.class), new Object[] { quizQuestionId });
		if (rs != null && rs.size() > 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

	public int delete(Long quizQuestionId) {
		return jdbcTemplate.update(
				"UPDATE `quiz`.`quiz_question` SET `deleted` = 'Y', `updated_on` = now() WHERE `id` = ?",
				new Object[] { quizQuestionId });
	}

}
