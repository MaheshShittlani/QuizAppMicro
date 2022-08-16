package com.learn.quiz.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.quiz.entity.Question;

@Repository
public class QuestionDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Question> findAllByDeleted(Character deleted) {
		return jdbcTemplate.query("SELECT q.* from question q where q.deleted = 'N'",
				new BeanPropertyRowMapper<Question>(Question.class));
	}

	public Question findById(Long questionId) {
		List<Question> rs = jdbcTemplate.query("SELECT q.* from question q where q.id = ? and q.deleted = 'N'",
				new BeanPropertyRowMapper<Question>(Question.class), new Object[] { questionId });
		if (rs != null && rs.size() > 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

	public int save(Question question) {
		return jdbcTemplate.update(
				"INSERT INTO quiz.question "
						+ "( question, option_a, option_b, option_c, option_d, right_option, deleted)"
						+ " VALUES ( ?, ?, ?, ?, ?, ?, 'N' );",
				new Object[] { question.getQuestion(), question.getOptionA(), question.getOptionB(),
						question.getOptionC(), question.getOptionD(), question.getRightOption().toString() });
	}

	public int update(Question question) {
		return jdbcTemplate.update(
				"UPDATE quiz.question SET question = ?, option_a = ?, option_b = ?, option_c = ?, option_d = ?, "
						+ "right_option = ?, deleted = 'N', updated_on = now() WHERE id = ? ",
				new Object[] { question.getQuestion(), question.getOptionA(), question.getOptionB(),
						question.getOptionC(), question.getOptionD(), question.getRightOption().toString(),
						question.getId() });
	}
	
	public int delete(Long questionId) {
		return jdbcTemplate.update("UPDATE quiz.question SET deleted = 'Y', updated_on = now() WHERE id = ? ",
				new Object[] { questionId });
	}

}
