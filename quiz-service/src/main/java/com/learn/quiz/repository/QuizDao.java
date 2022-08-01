package com.learn.quiz.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuizDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

}
