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

	public Question findById(Long questionId) {
		List<Question> rs = jdbcTemplate.query("SELECT q.* from question q where q.id = ? and q.deleted = 'N'",
				new BeanPropertyRowMapper<Question>(Question.class), new Object[] { questionId });
		if (rs != null && rs.size() > 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

}
