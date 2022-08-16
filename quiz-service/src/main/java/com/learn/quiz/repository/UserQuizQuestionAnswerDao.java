package com.learn.quiz.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.quiz.dto.UserScore;
import com.learn.quiz.entity.UserQuizQuestionAnswer;

@Repository
public class UserQuizQuestionAnswerDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public UserQuizQuestionAnswer findByQuizQuestionIdAndUserId(Long quizQuestionId, Long userId) {
		List<UserQuizQuestionAnswer> rs = jdbcTemplate.query(
				"SELECT q.* FROM quiz.user_quiz_ques_ans q where q.quiz_question_id = ? and q.user_id = ?",
				new BeanPropertyRowMapper<UserQuizQuestionAnswer>(UserQuizQuestionAnswer.class),
				new Object[] { quizQuestionId, userId });
		if (rs != null && rs.size() > 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

	public UserQuizQuestionAnswer findById(Long userQuizQuestionAnswerId) {
		List<UserQuizQuestionAnswer> rs = jdbcTemplate.query("SELECT q.* FROM quiz.user_quiz_ques_ans q where q.id = ?",
				new BeanPropertyRowMapper<UserQuizQuestionAnswer>(UserQuizQuestionAnswer.class),
				new Object[] { userQuizQuestionAnswerId });
		if (rs != null && rs.size() > 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

	public int save(UserQuizQuestionAnswer userQuizQuestionAnswer) {
		return jdbcTemplate.update(
				"INSERT INTO `quiz`.`user_quiz_ques_ans` ( `user_id`, `quiz_question_id`, `selected_option`) VALUES (?, ?, ? )",
				new Object[] { userQuizQuestionAnswer.getUserId(), userQuizQuestionAnswer.getQuizQuestionId(),
						userQuizQuestionAnswer.getSelectedOption().toString() });
	}

	public List<UserQuizQuestionAnswer> findAll() {
		return jdbcTemplate.query("SELECT q.* FROM quiz.cd  q",
				new BeanPropertyRowMapper<UserQuizQuestionAnswer>(UserQuizQuestionAnswer.class));
	}

	public List<UserScore> getLeaderBoard(Long quizId) {
		return jdbcTemplate.query(
				"select u.first_name, u.last_name, count(uqqa.id) score from quiz.user_quiz_ques_ans uqqa "
						+ " inner join quiz_question qq on qq.id = uqqa.quiz_question_id "
						+ " inner join question q on q.id = qq.question_id "
						+ " inner join user u on u.id = uqqa.user_id "
						+ " where q.right_option = uqqa.selected_option and qq.quiz_id = ? "
						+ " group by u.first_name, u.last_name, uqqa.id order by count(uqqa.id) desc",
				new BeanPropertyRowMapper<UserScore>(UserScore.class), quizId);
	}
}
