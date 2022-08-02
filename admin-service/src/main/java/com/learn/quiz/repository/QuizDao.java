package com.learn.quiz.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.quiz.entity.Quiz;

@Repository
public class QuizDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Quiz> findAllByDeleted(Character deleted) {
		return jdbcTemplate.query("SELECT q.* from quiz q where q.deleted = 'N'",
				new BeanPropertyRowMapper<Quiz>(Quiz.class));
	}

	public Quiz findById(Long quizId) {
		List<Quiz> rs = jdbcTemplate.query("SELECT q.* from quiz q where q.deleted = 'N' and q.id = ?",
				new BeanPropertyRowMapper<Quiz>(Quiz.class), new Object[] { quizId });
		if (rs != null && rs.size() > 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

	public int save(Quiz quiz) {
		if (quiz.getId() == null) {
			return persist(quiz);
		} else {
			return merge(quiz);
		}
	}

	private int merge(Quiz quiz) {
		return jdbcTemplate.update(
				"UPDATE `quiz`.`quiz` SET `title` = 	?, `category` =?, `deleted` = ?, `updated_on` = now() WHERE `id` = ?",
				new Object[] { quiz.getTitle(), quiz.getCategory(), quiz.getDeleted().toString(), quiz.getId() });
	}

	private int persist(Quiz quiz) {
		return jdbcTemplate.update("INSERT INTO `quiz`.`quiz` ( `title`, `category`, `deleted`) VALUES (?, ?, 'N' )",
				new Object[] { quiz.getTitle(), quiz.getCategory() });
	}

}
